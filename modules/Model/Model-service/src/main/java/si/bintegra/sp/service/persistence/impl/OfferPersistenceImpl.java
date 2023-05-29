/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package si.bintegra.sp.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.model.OfferTable;
import si.bintegra.sp.model.impl.OfferImpl;
import si.bintegra.sp.model.impl.OfferModelImpl;
import si.bintegra.sp.service.persistence.OfferPersistence;
import si.bintegra.sp.service.persistence.OfferUtil;
import si.bintegra.sp.service.persistence.impl.constants.SPPersistenceConstants;

/**
 * The persistence implementation for the offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OfferPersistence.class)
public class OfferPersistenceImpl
	extends BasePersistenceImpl<Offer> implements OfferPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OfferUtil</code> to access the offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OfferImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBytype;
	private FinderPath _finderPathWithoutPaginationFindBytype;
	private FinderPath _finderPathCountBytype;

	/**
	 * Returns all the offers where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching offers
	 */
	@Override
	public List<Offer> findBytype(String type) {
		return findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the offers where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	@Override
	public List<Offer> findBytype(String type, int start, int end) {
		return findBytype(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the offers where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	@Override
	public List<Offer> findBytype(
		String type, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return findBytype(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the offers where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offers
	 */
	@Override
	public List<Offer> findBytype(
		String type, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytype;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytype;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<Offer> list = null;

		if (useFinderCache) {
			list = (List<Offer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Offer offer : list) {
					if (!type.equals(offer.getType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OFFER_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				list = (List<Offer>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	@Override
	public Offer findBytype_First(
			String type, OrderByComparator<Offer> orderByComparator)
		throws NoSuchOfferException {

		Offer offer = fetchBytype_First(type, orderByComparator);

		if (offer != null) {
			return offer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOfferException(sb.toString());
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	@Override
	public Offer fetchBytype_First(
		String type, OrderByComparator<Offer> orderByComparator) {

		List<Offer> list = findBytype(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	@Override
	public Offer findBytype_Last(
			String type, OrderByComparator<Offer> orderByComparator)
		throws NoSuchOfferException {

		Offer offer = fetchBytype_Last(type, orderByComparator);

		if (offer != null) {
			return offer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchOfferException(sb.toString());
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	@Override
	public Offer fetchBytype_Last(
		String type, OrderByComparator<Offer> orderByComparator) {

		int count = countBytype(type);

		if (count == 0) {
			return null;
		}

		List<Offer> list = findBytype(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the offers before and after the current offer in the ordered set where type = &#63;.
	 *
	 * @param id the primary key of the current offer
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	@Override
	public Offer[] findBytype_PrevAndNext(
			long id, String type, OrderByComparator<Offer> orderByComparator)
		throws NoSuchOfferException {

		type = Objects.toString(type, "");

		Offer offer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Offer[] array = new OfferImpl[3];

			array[0] = getBytype_PrevAndNext(
				session, offer, type, orderByComparator, true);

			array[1] = offer;

			array[2] = getBytype_PrevAndNext(
				session, offer, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Offer getBytype_PrevAndNext(
		Session session, Offer offer, String type,
		OrderByComparator<Offer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OFFER_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(offer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Offer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the offers where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeBytype(String type) {
		for (Offer offer :
				findBytype(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(offer);
		}
	}

	/**
	 * Returns the number of offers where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching offers
	 */
	@Override
	public int countBytype(String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountBytype;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OFFER_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "offer.type = ?";

	private static final String _FINDER_COLUMN_TYPE_TYPE_3 =
		"(offer.type IS NULL OR offer.type = '')";

	private FinderPath _finderPathWithPaginationFindBytypeAndActive;
	private FinderPath _finderPathWithoutPaginationFindBytypeAndActive;
	private FinderPath _finderPathCountBytypeAndActive;

	/**
	 * Returns all the offers where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @return the matching offers
	 */
	@Override
	public List<Offer> findBytypeAndActive(String type, Boolean active) {
		return findBytypeAndActive(
			type, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the offers where type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param active the active
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of matching offers
	 */
	@Override
	public List<Offer> findBytypeAndActive(
		String type, Boolean active, int start, int end) {

		return findBytypeAndActive(type, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the offers where type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param active the active
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offers
	 */
	@Override
	public List<Offer> findBytypeAndActive(
		String type, Boolean active, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return findBytypeAndActive(
			type, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the offers where type = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param active the active
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offers
	 */
	@Override
	public List<Offer> findBytypeAndActive(
		String type, Boolean active, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytypeAndActive;
				finderArgs = new Object[] {type, active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytypeAndActive;
			finderArgs = new Object[] {
				type, active, start, end, orderByComparator
			};
		}

		List<Offer> list = null;

		if (useFinderCache) {
			list = (List<Offer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Offer offer : list) {
					if (!type.equals(offer.getType()) ||
						!Objects.equals(active, offer.getActive())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_OFFER_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDACTIVE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDACTIVE_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				queryPos.add(active.booleanValue());

				list = (List<Offer>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	@Override
	public Offer findBytypeAndActive_First(
			String type, Boolean active,
			OrderByComparator<Offer> orderByComparator)
		throws NoSuchOfferException {

		Offer offer = fetchBytypeAndActive_First(
			type, active, orderByComparator);

		if (offer != null) {
			return offer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchOfferException(sb.toString());
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	@Override
	public Offer fetchBytypeAndActive_First(
		String type, Boolean active,
		OrderByComparator<Offer> orderByComparator) {

		List<Offer> list = findBytypeAndActive(
			type, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	@Override
	public Offer findBytypeAndActive_Last(
			String type, Boolean active,
			OrderByComparator<Offer> orderByComparator)
		throws NoSuchOfferException {

		Offer offer = fetchBytypeAndActive_Last(
			type, active, orderByComparator);

		if (offer != null) {
			return offer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchOfferException(sb.toString());
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	@Override
	public Offer fetchBytypeAndActive_Last(
		String type, Boolean active,
		OrderByComparator<Offer> orderByComparator) {

		int count = countBytypeAndActive(type, active);

		if (count == 0) {
			return null;
		}

		List<Offer> list = findBytypeAndActive(
			type, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the offers before and after the current offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param id the primary key of the current offer
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	@Override
	public Offer[] findBytypeAndActive_PrevAndNext(
			long id, String type, Boolean active,
			OrderByComparator<Offer> orderByComparator)
		throws NoSuchOfferException {

		type = Objects.toString(type, "");

		Offer offer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Offer[] array = new OfferImpl[3];

			array[0] = getBytypeAndActive_PrevAndNext(
				session, offer, type, active, orderByComparator, true);

			array[1] = offer;

			array[2] = getBytypeAndActive_PrevAndNext(
				session, offer, type, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Offer getBytypeAndActive_PrevAndNext(
		Session session, Offer offer, String type, Boolean active,
		OrderByComparator<Offer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_OFFER_WHERE);

		boolean bindType = false;

		if (type.isEmpty()) {
			sb.append(_FINDER_COLUMN_TYPEANDACTIVE_TYPE_3);
		}
		else {
			bindType = true;

			sb.append(_FINDER_COLUMN_TYPEANDACTIVE_TYPE_2);
		}

		sb.append(_FINDER_COLUMN_TYPEANDACTIVE_ACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindType) {
			queryPos.add(type);
		}

		queryPos.add(active.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(offer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Offer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the offers where type = &#63; and active = &#63; from the database.
	 *
	 * @param type the type
	 * @param active the active
	 */
	@Override
	public void removeBytypeAndActive(String type, Boolean active) {
		for (Offer offer :
				findBytypeAndActive(
					type, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(offer);
		}
	}

	/**
	 * Returns the number of offers where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @return the number of matching offers
	 */
	@Override
	public int countBytypeAndActive(String type, Boolean active) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountBytypeAndActive;

		Object[] finderArgs = new Object[] {type, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_OFFER_WHERE);

			boolean bindType = false;

			if (type.isEmpty()) {
				sb.append(_FINDER_COLUMN_TYPEANDACTIVE_TYPE_3);
			}
			else {
				bindType = true;

				sb.append(_FINDER_COLUMN_TYPEANDACTIVE_TYPE_2);
			}

			sb.append(_FINDER_COLUMN_TYPEANDACTIVE_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindType) {
					queryPos.add(type);
				}

				queryPos.add(active.booleanValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPEANDACTIVE_TYPE_2 =
		"offer.type = ? AND ";

	private static final String _FINDER_COLUMN_TYPEANDACTIVE_TYPE_3 =
		"(offer.type IS NULL OR offer.type = '') AND ";

	private static final String _FINDER_COLUMN_TYPEANDACTIVE_ACTIVE_2 =
		"offer.active = ?";

	public OfferPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Offer.class);

		setModelImplClass(OfferImpl.class);
		setModelPKClass(long.class);

		setTable(OfferTable.INSTANCE);
	}

	/**
	 * Caches the offer in the entity cache if it is enabled.
	 *
	 * @param offer the offer
	 */
	@Override
	public void cacheResult(Offer offer) {
		entityCache.putResult(OfferImpl.class, offer.getPrimaryKey(), offer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the offers in the entity cache if it is enabled.
	 *
	 * @param offers the offers
	 */
	@Override
	public void cacheResult(List<Offer> offers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (offers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Offer offer : offers) {
			if (entityCache.getResult(OfferImpl.class, offer.getPrimaryKey()) ==
					null) {

				cacheResult(offer);
			}
		}
	}

	/**
	 * Clears the cache for all offers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OfferImpl.class);

		finderCache.clearCache(OfferImpl.class);
	}

	/**
	 * Clears the cache for the offer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Offer offer) {
		entityCache.removeResult(OfferImpl.class, offer);
	}

	@Override
	public void clearCache(List<Offer> offers) {
		for (Offer offer : offers) {
			entityCache.removeResult(OfferImpl.class, offer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OfferImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OfferImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param id the primary key for the new offer
	 * @return the new offer
	 */
	@Override
	public Offer create(long id) {
		Offer offer = new OfferImpl();

		offer.setNew(true);
		offer.setPrimaryKey(id);

		return offer;
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the offer
	 * @return the offer that was removed
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	@Override
	public Offer remove(long id) throws NoSuchOfferException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the offer
	 * @return the offer that was removed
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	@Override
	public Offer remove(Serializable primaryKey) throws NoSuchOfferException {
		Session session = null;

		try {
			session = openSession();

			Offer offer = (Offer)session.get(OfferImpl.class, primaryKey);

			if (offer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfferException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(offer);
		}
		catch (NoSuchOfferException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Offer removeImpl(Offer offer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(offer)) {
				offer = (Offer)session.get(
					OfferImpl.class, offer.getPrimaryKeyObj());
			}

			if (offer != null) {
				session.delete(offer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (offer != null) {
			clearCache(offer);
		}

		return offer;
	}

	@Override
	public Offer updateImpl(Offer offer) {
		boolean isNew = offer.isNew();

		if (!(offer instanceof OfferModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(offer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(offer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in offer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Offer implementation " +
					offer.getClass());
		}

		OfferModelImpl offerModelImpl = (OfferModelImpl)offer;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(offer);
			}
			else {
				offer = (Offer)session.merge(offer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(OfferImpl.class, offerModelImpl, false, true);

		if (isNew) {
			offer.setNew(false);
		}

		offer.resetOriginalValues();

		return offer;
	}

	/**
	 * Returns the offer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the offer
	 * @return the offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	@Override
	public Offer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfferException {

		Offer offer = fetchByPrimaryKey(primaryKey);

		if (offer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfferException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return offer;
	}

	/**
	 * Returns the offer with the primary key or throws a <code>NoSuchOfferException</code> if it could not be found.
	 *
	 * @param id the primary key of the offer
	 * @return the offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	@Override
	public Offer findByPrimaryKey(long id) throws NoSuchOfferException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the offer
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 */
	@Override
	public Offer fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the offers.
	 *
	 * @return the offers
	 */
	@Override
	public List<Offer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of offers
	 */
	@Override
	public List<Offer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offers
	 */
	@Override
	public List<Offer> findAll(
		int start, int end, OrderByComparator<Offer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of offers
	 */
	@Override
	public List<Offer> findAll(
		int start, int end, OrderByComparator<Offer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Offer> list = null;

		if (useFinderCache) {
			list = (List<Offer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OFFER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OFFER;

				sql = sql.concat(OfferModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Offer>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the offers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Offer offer : findAll()) {
			remove(offer);
		}
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OFFER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OFFER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OfferModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the offer persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytype",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytype",
			new String[] {String.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountBytype = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytype",
			new String[] {String.class.getName()}, new String[] {"type_"},
			false);

		_finderPathWithPaginationFindBytypeAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytypeAndActive",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"type_", "active_"}, true);

		_finderPathWithoutPaginationFindBytypeAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytypeAndActive",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"type_", "active_"}, true);

		_finderPathCountBytypeAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytypeAndActive",
			new String[] {String.class.getName(), Boolean.class.getName()},
			new String[] {"type_", "active_"}, false);

		_setOfferUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setOfferUtilPersistence(null);

		entityCache.removeCache(OfferImpl.class.getName());
	}

	private void _setOfferUtilPersistence(OfferPersistence offerPersistence) {
		try {
			Field field = OfferUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, offerPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OFFER =
		"SELECT offer FROM Offer offer";

	private static final String _SQL_SELECT_OFFER_WHERE =
		"SELECT offer FROM Offer offer WHERE ";

	private static final String _SQL_COUNT_OFFER =
		"SELECT COUNT(offer) FROM Offer offer";

	private static final String _SQL_COUNT_OFFER_WHERE =
		"SELECT COUNT(offer) FROM Offer offer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "offer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Offer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Offer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OfferPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}