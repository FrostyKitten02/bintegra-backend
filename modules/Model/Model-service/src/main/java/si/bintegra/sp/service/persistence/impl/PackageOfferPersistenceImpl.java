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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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

import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.model.PackageOfferTable;
import si.bintegra.sp.model.impl.PackageOfferImpl;
import si.bintegra.sp.model.impl.PackageOfferModelImpl;
import si.bintegra.sp.service.persistence.PackageOfferPersistence;
import si.bintegra.sp.service.persistence.PackageOfferUtil;
import si.bintegra.sp.service.persistence.impl.constants.SPPersistenceConstants;

/**
 * The persistence implementation for the package offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PackageOfferPersistence.class)
public class PackageOfferPersistenceImpl
	extends BasePersistenceImpl<PackageOffer>
	implements PackageOfferPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PackageOfferUtil</code> to access the package offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PackageOfferImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByid;
	private FinderPath _finderPathCountByid;

	/**
	 * Returns the package offer where id = &#63; or throws a <code>NoSuchPackageOfferException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByid(long id) throws NoSuchPackageOfferException {
		PackageOffer packageOffer = fetchByid(id);

		if (packageOffer == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("id=");
			sb.append(id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPackageOfferException(sb.toString());
		}

		return packageOffer;
	}

	/**
	 * Returns the package offer where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByid(long id) {
		return fetchByid(id, true);
	}

	/**
	 * Returns the package offer where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByid(long id, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {id};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByid, finderArgs, this);
		}

		if (result instanceof PackageOffer) {
			PackageOffer packageOffer = (PackageOffer)result;

			if (id != packageOffer.getId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

				List<PackageOffer> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByid, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {id};
							}

							_log.warn(
								"PackageOfferPersistenceImpl.fetchByid(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PackageOffer packageOffer = list.get(0);

					result = packageOffer;

					cacheResult(packageOffer);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PackageOffer)result;
		}
	}

	/**
	 * Removes the package offer where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the package offer that was removed
	 */
	@Override
	public PackageOffer removeByid(long id) throws NoSuchPackageOfferException {
		PackageOffer packageOffer = findByid(id);

		return remove(packageOffer);
	}

	/**
	 * Returns the number of package offers where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching package offers
	 */
	@Override
	public int countByid(long id) {
		FinderPath finderPath = _finderPathCountByid;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_ID_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(id);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "packageOffer.id = ?";

	private FinderPath _finderPathWithPaginationFindByactive;
	private FinderPath _finderPathWithoutPaginationFindByactive;
	private FinderPath _finderPathCountByactive;

	/**
	 * Returns all the package offers where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching package offers
	 */
	@Override
	public List<PackageOffer> findByactive(Boolean active) {
		return findByactive(active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the package offers where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByactive(Boolean active, int start, int end) {
		return findByactive(active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the package offers where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByactive(
		Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return findByactive(active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the package offers where active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByactive(
		Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactive;
				finderArgs = new Object[] {active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactive;
			finderArgs = new Object[] {active, start, end, orderByComparator};
		}

		List<PackageOffer> list = null;

		if (useFinderCache) {
			list = (List<PackageOffer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PackageOffer packageOffer : list) {
					if (!Objects.equals(active, packageOffer.getActive())) {
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

			sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PackageOfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(active.booleanValue());

				list = (List<PackageOffer>)QueryUtil.list(
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
	 * Returns the first package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByactive_First(
			Boolean active, OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByactive_First(
			active, orderByComparator);

		if (packageOffer != null) {
			return packageOffer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchPackageOfferException(sb.toString());
	}

	/**
	 * Returns the first package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByactive_First(
		Boolean active, OrderByComparator<PackageOffer> orderByComparator) {

		List<PackageOffer> list = findByactive(active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByactive_Last(
			Boolean active, OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByactive_Last(
			active, orderByComparator);

		if (packageOffer != null) {
			return packageOffer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchPackageOfferException(sb.toString());
	}

	/**
	 * Returns the last package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByactive_Last(
		Boolean active, OrderByComparator<PackageOffer> orderByComparator) {

		int count = countByactive(active);

		if (count == 0) {
			return null;
		}

		List<PackageOffer> list = findByactive(
			active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the package offers before and after the current package offer in the ordered set where active = &#63;.
	 *
	 * @param id the primary key of the current package offer
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer[] findByactive_PrevAndNext(
			long id, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PackageOffer[] array = new PackageOfferImpl[3];

			array[0] = getByactive_PrevAndNext(
				session, packageOffer, active, orderByComparator, true);

			array[1] = packageOffer;

			array[2] = getByactive_PrevAndNext(
				session, packageOffer, active, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PackageOffer getByactive_PrevAndNext(
		Session session, PackageOffer packageOffer, Boolean active,
		OrderByComparator<PackageOffer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

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
			sb.append(PackageOfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(active.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(packageOffer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PackageOffer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the package offers where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	@Override
	public void removeByactive(Boolean active) {
		for (PackageOffer packageOffer :
				findByactive(
					active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(packageOffer);
		}
	}

	/**
	 * Returns the number of package offers where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching package offers
	 */
	@Override
	public int countByactive(Boolean active) {
		FinderPath finderPath = _finderPathCountByactive;

		Object[] finderArgs = new Object[] {active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVE_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

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

	private static final String _FINDER_COLUMN_ACTIVE_ACTIVE_2 =
		"packageOffer.active = ?";

	private FinderPath _finderPathWithPaginationFindByofferId;
	private FinderPath _finderPathWithoutPaginationFindByofferId;
	private FinderPath _finderPathCountByofferId;

	/**
	 * Returns all the package offers where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferId(Long offerId) {
		return findByofferId(
			offerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the package offers where offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferId(Long offerId, int start, int end) {
		return findByofferId(offerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the package offers where offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return findByofferId(offerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the package offers where offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByofferId;
				finderArgs = new Object[] {offerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByofferId;
			finderArgs = new Object[] {offerId, start, end, orderByComparator};
		}

		List<PackageOffer> list = null;

		if (useFinderCache) {
			list = (List<PackageOffer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PackageOffer packageOffer : list) {
					if (!Objects.equals(offerId, packageOffer.getOfferId())) {
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

			sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_OFFERID_OFFERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PackageOfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(offerId.longValue());

				list = (List<PackageOffer>)QueryUtil.list(
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
	 * Returns the first package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByofferId_First(
			Long offerId, OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByofferId_First(
			offerId, orderByComparator);

		if (packageOffer != null) {
			return packageOffer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("offerId=");
		sb.append(offerId);

		sb.append("}");

		throw new NoSuchPackageOfferException(sb.toString());
	}

	/**
	 * Returns the first package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByofferId_First(
		Long offerId, OrderByComparator<PackageOffer> orderByComparator) {

		List<PackageOffer> list = findByofferId(
			offerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByofferId_Last(
			Long offerId, OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByofferId_Last(
			offerId, orderByComparator);

		if (packageOffer != null) {
			return packageOffer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("offerId=");
		sb.append(offerId);

		sb.append("}");

		throw new NoSuchPackageOfferException(sb.toString());
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByofferId_Last(
		Long offerId, OrderByComparator<PackageOffer> orderByComparator) {

		int count = countByofferId(offerId);

		if (count == 0) {
			return null;
		}

		List<PackageOffer> list = findByofferId(
			offerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the package offers before and after the current package offer in the ordered set where offerId = &#63;.
	 *
	 * @param id the primary key of the current package offer
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer[] findByofferId_PrevAndNext(
			long id, Long offerId,
			OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PackageOffer[] array = new PackageOfferImpl[3];

			array[0] = getByofferId_PrevAndNext(
				session, packageOffer, offerId, orderByComparator, true);

			array[1] = packageOffer;

			array[2] = getByofferId_PrevAndNext(
				session, packageOffer, offerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PackageOffer getByofferId_PrevAndNext(
		Session session, PackageOffer packageOffer, Long offerId,
		OrderByComparator<PackageOffer> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

		sb.append(_FINDER_COLUMN_OFFERID_OFFERID_2);

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
			sb.append(PackageOfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(offerId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(packageOffer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PackageOffer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the package offers where offerId = &#63; from the database.
	 *
	 * @param offerId the offer ID
	 */
	@Override
	public void removeByofferId(Long offerId) {
		for (PackageOffer packageOffer :
				findByofferId(
					offerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(packageOffer);
		}
	}

	/**
	 * Returns the number of package offers where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the number of matching package offers
	 */
	@Override
	public int countByofferId(Long offerId) {
		FinderPath finderPath = _finderPathCountByofferId;

		Object[] finderArgs = new Object[] {offerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_OFFERID_OFFERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(offerId.longValue());

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

	private static final String _FINDER_COLUMN_OFFERID_OFFERID_2 =
		"packageOffer.offerId = ?";

	private FinderPath _finderPathWithPaginationFindByofferIdAndActive;
	private FinderPath _finderPathWithoutPaginationFindByofferIdAndActive;
	private FinderPath _finderPathCountByofferIdAndActive;

	/**
	 * Returns all the package offers where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @return the matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active) {

		return findByofferIdAndActive(
			offerId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the package offers where offerId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active, int start, int end) {

		return findByofferIdAndActive(offerId, active, start, end, null);
	}

	/**
	 * Returns an ordered range of all the package offers where offerId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return findByofferIdAndActive(
			offerId, active, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the package offers where offerId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching package offers
	 */
	@Override
	public List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByofferIdAndActive;
				finderArgs = new Object[] {offerId, active};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByofferIdAndActive;
			finderArgs = new Object[] {
				offerId, active, start, end, orderByComparator
			};
		}

		List<PackageOffer> list = null;

		if (useFinderCache) {
			list = (List<PackageOffer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PackageOffer packageOffer : list) {
					if (!Objects.equals(offerId, packageOffer.getOfferId()) ||
						!Objects.equals(active, packageOffer.getActive())) {

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

			sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_OFFERIDANDACTIVE_OFFERID_2);

			sb.append(_FINDER_COLUMN_OFFERIDANDACTIVE_ACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PackageOfferModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(offerId.longValue());

				queryPos.add(active.booleanValue());

				list = (List<PackageOffer>)QueryUtil.list(
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
	 * Returns the first package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByofferIdAndActive_First(
			Long offerId, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByofferIdAndActive_First(
			offerId, active, orderByComparator);

		if (packageOffer != null) {
			return packageOffer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("offerId=");
		sb.append(offerId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchPackageOfferException(sb.toString());
	}

	/**
	 * Returns the first package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByofferIdAndActive_First(
		Long offerId, Boolean active,
		OrderByComparator<PackageOffer> orderByComparator) {

		List<PackageOffer> list = findByofferIdAndActive(
			offerId, active, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	@Override
	public PackageOffer findByofferIdAndActive_Last(
			Long offerId, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByofferIdAndActive_Last(
			offerId, active, orderByComparator);

		if (packageOffer != null) {
			return packageOffer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("offerId=");
		sb.append(offerId);

		sb.append(", active=");
		sb.append(active);

		sb.append("}");

		throw new NoSuchPackageOfferException(sb.toString());
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	@Override
	public PackageOffer fetchByofferIdAndActive_Last(
		Long offerId, Boolean active,
		OrderByComparator<PackageOffer> orderByComparator) {

		int count = countByofferIdAndActive(offerId, active);

		if (count == 0) {
			return null;
		}

		List<PackageOffer> list = findByofferIdAndActive(
			offerId, active, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the package offers before and after the current package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param id the primary key of the current package offer
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer[] findByofferIdAndActive_PrevAndNext(
			long id, Long offerId, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			PackageOffer[] array = new PackageOfferImpl[3];

			array[0] = getByofferIdAndActive_PrevAndNext(
				session, packageOffer, offerId, active, orderByComparator,
				true);

			array[1] = packageOffer;

			array[2] = getByofferIdAndActive_PrevAndNext(
				session, packageOffer, offerId, active, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PackageOffer getByofferIdAndActive_PrevAndNext(
		Session session, PackageOffer packageOffer, Long offerId,
		Boolean active, OrderByComparator<PackageOffer> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PACKAGEOFFER_WHERE);

		sb.append(_FINDER_COLUMN_OFFERIDANDACTIVE_OFFERID_2);

		sb.append(_FINDER_COLUMN_OFFERIDANDACTIVE_ACTIVE_2);

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
			sb.append(PackageOfferModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(offerId.longValue());

		queryPos.add(active.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(packageOffer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PackageOffer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the package offers where offerId = &#63; and active = &#63; from the database.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 */
	@Override
	public void removeByofferIdAndActive(Long offerId, Boolean active) {
		for (PackageOffer packageOffer :
				findByofferIdAndActive(
					offerId, active, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(packageOffer);
		}
	}

	/**
	 * Returns the number of package offers where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @return the number of matching package offers
	 */
	@Override
	public int countByofferIdAndActive(Long offerId, Boolean active) {
		FinderPath finderPath = _finderPathCountByofferIdAndActive;

		Object[] finderArgs = new Object[] {offerId, active};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PACKAGEOFFER_WHERE);

			sb.append(_FINDER_COLUMN_OFFERIDANDACTIVE_OFFERID_2);

			sb.append(_FINDER_COLUMN_OFFERIDANDACTIVE_ACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(offerId.longValue());

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

	private static final String _FINDER_COLUMN_OFFERIDANDACTIVE_OFFERID_2 =
		"packageOffer.offerId = ? AND ";

	private static final String _FINDER_COLUMN_OFFERIDANDACTIVE_ACTIVE_2 =
		"packageOffer.active = ?";

	public PackageOfferPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("active", "active_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PackageOffer.class);

		setModelImplClass(PackageOfferImpl.class);
		setModelPKClass(long.class);

		setTable(PackageOfferTable.INSTANCE);
	}

	/**
	 * Caches the package offer in the entity cache if it is enabled.
	 *
	 * @param packageOffer the package offer
	 */
	@Override
	public void cacheResult(PackageOffer packageOffer) {
		entityCache.putResult(
			PackageOfferImpl.class, packageOffer.getPrimaryKey(), packageOffer);

		finderCache.putResult(
			_finderPathFetchByid, new Object[] {packageOffer.getId()},
			packageOffer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the package offers in the entity cache if it is enabled.
	 *
	 * @param packageOffers the package offers
	 */
	@Override
	public void cacheResult(List<PackageOffer> packageOffers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (packageOffers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PackageOffer packageOffer : packageOffers) {
			if (entityCache.getResult(
					PackageOfferImpl.class, packageOffer.getPrimaryKey()) ==
						null) {

				cacheResult(packageOffer);
			}
		}
	}

	/**
	 * Clears the cache for all package offers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PackageOfferImpl.class);

		finderCache.clearCache(PackageOfferImpl.class);
	}

	/**
	 * Clears the cache for the package offer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PackageOffer packageOffer) {
		entityCache.removeResult(PackageOfferImpl.class, packageOffer);
	}

	@Override
	public void clearCache(List<PackageOffer> packageOffers) {
		for (PackageOffer packageOffer : packageOffers) {
			entityCache.removeResult(PackageOfferImpl.class, packageOffer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PackageOfferImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PackageOfferImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PackageOfferModelImpl packageOfferModelImpl) {

		Object[] args = new Object[] {packageOfferModelImpl.getId()};

		finderCache.putResult(_finderPathCountByid, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByid, args, packageOfferModelImpl);
	}

	/**
	 * Creates a new package offer with the primary key. Does not add the package offer to the database.
	 *
	 * @param id the primary key for the new package offer
	 * @return the new package offer
	 */
	@Override
	public PackageOffer create(long id) {
		PackageOffer packageOffer = new PackageOfferImpl();

		packageOffer.setNew(true);
		packageOffer.setPrimaryKey(id);

		return packageOffer;
	}

	/**
	 * Removes the package offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer that was removed
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer remove(long id) throws NoSuchPackageOfferException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the package offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the package offer
	 * @return the package offer that was removed
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer remove(Serializable primaryKey)
		throws NoSuchPackageOfferException {

		Session session = null;

		try {
			session = openSession();

			PackageOffer packageOffer = (PackageOffer)session.get(
				PackageOfferImpl.class, primaryKey);

			if (packageOffer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPackageOfferException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(packageOffer);
		}
		catch (NoSuchPackageOfferException noSuchEntityException) {
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
	protected PackageOffer removeImpl(PackageOffer packageOffer) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(packageOffer)) {
				packageOffer = (PackageOffer)session.get(
					PackageOfferImpl.class, packageOffer.getPrimaryKeyObj());
			}

			if (packageOffer != null) {
				session.delete(packageOffer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (packageOffer != null) {
			clearCache(packageOffer);
		}

		return packageOffer;
	}

	@Override
	public PackageOffer updateImpl(PackageOffer packageOffer) {
		boolean isNew = packageOffer.isNew();

		if (!(packageOffer instanceof PackageOfferModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(packageOffer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					packageOffer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in packageOffer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PackageOffer implementation " +
					packageOffer.getClass());
		}

		PackageOfferModelImpl packageOfferModelImpl =
			(PackageOfferModelImpl)packageOffer;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(packageOffer);
			}
			else {
				packageOffer = (PackageOffer)session.merge(packageOffer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PackageOfferImpl.class, packageOfferModelImpl, false, true);

		cacheUniqueFindersCache(packageOfferModelImpl);

		if (isNew) {
			packageOffer.setNew(false);
		}

		packageOffer.resetOriginalValues();

		return packageOffer;
	}

	/**
	 * Returns the package offer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the package offer
	 * @return the package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPackageOfferException {

		PackageOffer packageOffer = fetchByPrimaryKey(primaryKey);

		if (packageOffer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPackageOfferException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return packageOffer;
	}

	/**
	 * Returns the package offer with the primary key or throws a <code>NoSuchPackageOfferException</code> if it could not be found.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer findByPrimaryKey(long id)
		throws NoSuchPackageOfferException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the package offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer, or <code>null</code> if a package offer with the primary key could not be found
	 */
	@Override
	public PackageOffer fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the package offers.
	 *
	 * @return the package offers
	 */
	@Override
	public List<PackageOffer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the package offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of package offers
	 */
	@Override
	public List<PackageOffer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the package offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of package offers
	 */
	@Override
	public List<PackageOffer> findAll(
		int start, int end, OrderByComparator<PackageOffer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the package offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of package offers
	 */
	@Override
	public List<PackageOffer> findAll(
		int start, int end, OrderByComparator<PackageOffer> orderByComparator,
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

		List<PackageOffer> list = null;

		if (useFinderCache) {
			list = (List<PackageOffer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PACKAGEOFFER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PACKAGEOFFER;

				sql = sql.concat(PackageOfferModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PackageOffer>)QueryUtil.list(
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
	 * Removes all the package offers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PackageOffer packageOffer : findAll()) {
			remove(packageOffer);
		}
	}

	/**
	 * Returns the number of package offers.
	 *
	 * @return the number of package offers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PACKAGEOFFER);

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
		return _SQL_SELECT_PACKAGEOFFER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PackageOfferModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the package offer persistence.
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

		_finderPathFetchByid = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByid",
			new String[] {Long.class.getName()}, new String[] {"id_"}, true);

		_finderPathCountByid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] {Long.class.getName()}, new String[] {"id_"}, false);

		_finderPathWithPaginationFindByactive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"active_"}, true);

		_finderPathWithoutPaginationFindByactive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactive",
			new String[] {Boolean.class.getName()}, new String[] {"active_"},
			true);

		_finderPathCountByactive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactive",
			new String[] {Boolean.class.getName()}, new String[] {"active_"},
			false);

		_finderPathWithPaginationFindByofferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByofferId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"offerId"}, true);

		_finderPathWithoutPaginationFindByofferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByofferId",
			new String[] {Long.class.getName()}, new String[] {"offerId"},
			true);

		_finderPathCountByofferId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByofferId",
			new String[] {Long.class.getName()}, new String[] {"offerId"},
			false);

		_finderPathWithPaginationFindByofferIdAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByofferIdAndActive",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"offerId", "active_"}, true);

		_finderPathWithoutPaginationFindByofferIdAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByofferIdAndActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"offerId", "active_"}, true);

		_finderPathCountByofferIdAndActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByofferIdAndActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"offerId", "active_"}, false);

		_setPackageOfferUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setPackageOfferUtilPersistence(null);

		entityCache.removeCache(PackageOfferImpl.class.getName());
	}

	private void _setPackageOfferUtilPersistence(
		PackageOfferPersistence packageOfferPersistence) {

		try {
			Field field = PackageOfferUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, packageOfferPersistence);
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

	private static final String _SQL_SELECT_PACKAGEOFFER =
		"SELECT packageOffer FROM PackageOffer packageOffer";

	private static final String _SQL_SELECT_PACKAGEOFFER_WHERE =
		"SELECT packageOffer FROM PackageOffer packageOffer WHERE ";

	private static final String _SQL_COUNT_PACKAGEOFFER =
		"SELECT COUNT(packageOffer) FROM PackageOffer packageOffer";

	private static final String _SQL_COUNT_PACKAGEOFFER_WHERE =
		"SELECT COUNT(packageOffer) FROM PackageOffer packageOffer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "packageOffer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PackageOffer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PackageOffer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PackageOfferPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "active"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}