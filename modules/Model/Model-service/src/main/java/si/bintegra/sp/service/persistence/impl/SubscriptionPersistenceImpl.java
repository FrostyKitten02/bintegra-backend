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

import si.bintegra.sp.exception.NoSuchSubscriptionException;
import si.bintegra.sp.model.Subscription;
import si.bintegra.sp.model.SubscriptionTable;
import si.bintegra.sp.model.impl.SubscriptionImpl;
import si.bintegra.sp.model.impl.SubscriptionModelImpl;
import si.bintegra.sp.service.persistence.SubscriptionPersistence;
import si.bintegra.sp.service.persistence.SubscriptionUtil;
import si.bintegra.sp.service.persistence.impl.constants.SPPersistenceConstants;

/**
 * The persistence implementation for the subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SubscriptionPersistence.class)
public class SubscriptionPersistenceImpl
	extends BasePersistenceImpl<Subscription>
	implements SubscriptionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SubscriptionUtil</code> to access the subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SubscriptionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByofferId;
	private FinderPath _finderPathWithoutPaginationFindByofferId;
	private FinderPath _finderPathCountByofferId;

	/**
	 * Returns all the subscriptions where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the matching subscriptions
	 */
	@Override
	public List<Subscription> findByofferId(Long offerId) {
		return findByofferId(
			offerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscriptions where offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 */
	@Override
	public List<Subscription> findByofferId(Long offerId, int start, int end) {
		return findByofferId(offerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscriptions where offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 */
	@Override
	public List<Subscription> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<Subscription> orderByComparator) {

		return findByofferId(offerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subscriptions where offerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param offerId the offer ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subscriptions
	 */
	@Override
	public List<Subscription> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<Subscription> orderByComparator,
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

		List<Subscription> list = null;

		if (useFinderCache) {
			list = (List<Subscription>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Subscription subscription : list) {
					if (!Objects.equals(offerId, subscription.getOfferId())) {
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

			sb.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_OFFERID_OFFERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(offerId.longValue());

				list = (List<Subscription>)QueryUtil.list(
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
	 * Returns the first subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	@Override
	public Subscription findByofferId_First(
			Long offerId, OrderByComparator<Subscription> orderByComparator)
		throws NoSuchSubscriptionException {

		Subscription subscription = fetchByofferId_First(
			offerId, orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("offerId=");
		sb.append(offerId);

		sb.append("}");

		throw new NoSuchSubscriptionException(sb.toString());
	}

	/**
	 * Returns the first subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	@Override
	public Subscription fetchByofferId_First(
		Long offerId, OrderByComparator<Subscription> orderByComparator) {

		List<Subscription> list = findByofferId(
			offerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	@Override
	public Subscription findByofferId_Last(
			Long offerId, OrderByComparator<Subscription> orderByComparator)
		throws NoSuchSubscriptionException {

		Subscription subscription = fetchByofferId_Last(
			offerId, orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("offerId=");
		sb.append(offerId);

		sb.append("}");

		throw new NoSuchSubscriptionException(sb.toString());
	}

	/**
	 * Returns the last subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	@Override
	public Subscription fetchByofferId_Last(
		Long offerId, OrderByComparator<Subscription> orderByComparator) {

		int count = countByofferId(offerId);

		if (count == 0) {
			return null;
		}

		List<Subscription> list = findByofferId(
			offerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where offerId = &#63;.
	 *
	 * @param id the primary key of the current subscription
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription[] findByofferId_PrevAndNext(
			long id, Long offerId,
			OrderByComparator<Subscription> orderByComparator)
		throws NoSuchSubscriptionException {

		Subscription subscription = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Subscription[] array = new SubscriptionImpl[3];

			array[0] = getByofferId_PrevAndNext(
				session, subscription, offerId, orderByComparator, true);

			array[1] = subscription;

			array[2] = getByofferId_PrevAndNext(
				session, subscription, offerId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subscription getByofferId_PrevAndNext(
		Session session, Subscription subscription, Long offerId,
		OrderByComparator<Subscription> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

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
			sb.append(SubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(offerId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subscription)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Subscription> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscriptions where offerId = &#63; from the database.
	 *
	 * @param offerId the offer ID
	 */
	@Override
	public void removeByofferId(Long offerId) {
		for (Subscription subscription :
				findByofferId(
					offerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subscription);
		}
	}

	/**
	 * Returns the number of subscriptions where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the number of matching subscriptions
	 */
	@Override
	public int countByofferId(Long offerId) {
		FinderPath finderPath = _finderPathCountByofferId;

		Object[] finderArgs = new Object[] {offerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBSCRIPTION_WHERE);

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
		"subscription.offerId = ?";

	private FinderPath _finderPathWithPaginationFindByuserId;
	private FinderPath _finderPathWithoutPaginationFindByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns all the subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching subscriptions
	 */
	@Override
	public List<Subscription> findByuserId(Long userId) {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 */
	@Override
	public List<Subscription> findByuserId(Long userId, int start, int end) {
		return findByuserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 */
	@Override
	public List<Subscription> findByuserId(
		Long userId, int start, int end,
		OrderByComparator<Subscription> orderByComparator) {

		return findByuserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subscriptions where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subscriptions
	 */
	@Override
	public List<Subscription> findByuserId(
		Long userId, int start, int end,
		OrderByComparator<Subscription> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByuserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByuserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<Subscription> list = null;

		if (useFinderCache) {
			list = (List<Subscription>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Subscription subscription : list) {
					if (!Objects.equals(userId, subscription.getUserId())) {
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

			sb.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SubscriptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId.longValue());

				list = (List<Subscription>)QueryUtil.list(
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
	 * Returns the first subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	@Override
	public Subscription findByuserId_First(
			Long userId, OrderByComparator<Subscription> orderByComparator)
		throws NoSuchSubscriptionException {

		Subscription subscription = fetchByuserId_First(
			userId, orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSubscriptionException(sb.toString());
	}

	/**
	 * Returns the first subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	@Override
	public Subscription fetchByuserId_First(
		Long userId, OrderByComparator<Subscription> orderByComparator) {

		List<Subscription> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	@Override
	public Subscription findByuserId_Last(
			Long userId, OrderByComparator<Subscription> orderByComparator)
		throws NoSuchSubscriptionException {

		Subscription subscription = fetchByuserId_Last(
			userId, orderByComparator);

		if (subscription != null) {
			return subscription;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchSubscriptionException(sb.toString());
	}

	/**
	 * Returns the last subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	@Override
	public Subscription fetchByuserId_Last(
		Long userId, OrderByComparator<Subscription> orderByComparator) {

		int count = countByuserId(userId);

		if (count == 0) {
			return null;
		}

		List<Subscription> list = findByuserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where userId = &#63;.
	 *
	 * @param id the primary key of the current subscription
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription[] findByuserId_PrevAndNext(
			long id, Long userId,
			OrderByComparator<Subscription> orderByComparator)
		throws NoSuchSubscriptionException {

		Subscription subscription = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Subscription[] array = new SubscriptionImpl[3];

			array[0] = getByuserId_PrevAndNext(
				session, subscription, userId, orderByComparator, true);

			array[1] = subscription;

			array[2] = getByuserId_PrevAndNext(
				session, subscription, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Subscription getByuserId_PrevAndNext(
		Session session, Subscription subscription, Long userId,
		OrderByComparator<Subscription> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(SubscriptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(subscription)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Subscription> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByuserId(Long userId) {
		for (Subscription subscription :
				findByuserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(subscription);
		}
	}

	/**
	 * Returns the number of subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching subscriptions
	 */
	@Override
	public int countByuserId(Long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SUBSCRIPTION_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId.longValue());

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"subscription.userId = ?";

	public SubscriptionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Subscription.class);

		setModelImplClass(SubscriptionImpl.class);
		setModelPKClass(long.class);

		setTable(SubscriptionTable.INSTANCE);
	}

	/**
	 * Caches the subscription in the entity cache if it is enabled.
	 *
	 * @param subscription the subscription
	 */
	@Override
	public void cacheResult(Subscription subscription) {
		entityCache.putResult(
			SubscriptionImpl.class, subscription.getPrimaryKey(), subscription);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the subscriptions in the entity cache if it is enabled.
	 *
	 * @param subscriptions the subscriptions
	 */
	@Override
	public void cacheResult(List<Subscription> subscriptions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (subscriptions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Subscription subscription : subscriptions) {
			if (entityCache.getResult(
					SubscriptionImpl.class, subscription.getPrimaryKey()) ==
						null) {

				cacheResult(subscription);
			}
		}
	}

	/**
	 * Clears the cache for all subscriptions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SubscriptionImpl.class);

		finderCache.clearCache(SubscriptionImpl.class);
	}

	/**
	 * Clears the cache for the subscription.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Subscription subscription) {
		entityCache.removeResult(SubscriptionImpl.class, subscription);
	}

	@Override
	public void clearCache(List<Subscription> subscriptions) {
		for (Subscription subscription : subscriptions) {
			entityCache.removeResult(SubscriptionImpl.class, subscription);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SubscriptionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SubscriptionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param id the primary key for the new subscription
	 * @return the new subscription
	 */
	@Override
	public Subscription create(long id) {
		Subscription subscription = new SubscriptionImpl();

		subscription.setNew(true);
		subscription.setPrimaryKey(id);

		return subscription;
	}

	/**
	 * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription remove(long id) throws NoSuchSubscriptionException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription remove(Serializable primaryKey)
		throws NoSuchSubscriptionException {

		Session session = null;

		try {
			session = openSession();

			Subscription subscription = (Subscription)session.get(
				SubscriptionImpl.class, primaryKey);

			if (subscription == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSubscriptionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(subscription);
		}
		catch (NoSuchSubscriptionException noSuchEntityException) {
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
	protected Subscription removeImpl(Subscription subscription) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(subscription)) {
				subscription = (Subscription)session.get(
					SubscriptionImpl.class, subscription.getPrimaryKeyObj());
			}

			if (subscription != null) {
				session.delete(subscription);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (subscription != null) {
			clearCache(subscription);
		}

		return subscription;
	}

	@Override
	public Subscription updateImpl(Subscription subscription) {
		boolean isNew = subscription.isNew();

		if (!(subscription instanceof SubscriptionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(subscription.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					subscription);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in subscription proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Subscription implementation " +
					subscription.getClass());
		}

		SubscriptionModelImpl subscriptionModelImpl =
			(SubscriptionModelImpl)subscription;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(subscription);
			}
			else {
				subscription = (Subscription)session.merge(subscription);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SubscriptionImpl.class, subscriptionModelImpl, false, true);

		if (isNew) {
			subscription.setNew(false);
		}

		subscription.resetOriginalValues();

		return subscription;
	}

	/**
	 * Returns the subscription with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the subscription
	 * @return the subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSubscriptionException {

		Subscription subscription = fetchByPrimaryKey(primaryKey);

		if (subscription == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSubscriptionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return subscription;
	}

	/**
	 * Returns the subscription with the primary key or throws a <code>NoSuchSubscriptionException</code> if it could not be found.
	 *
	 * @param id the primary key of the subscription
	 * @return the subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription findByPrimaryKey(long id)
		throws NoSuchSubscriptionException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the subscription
	 * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	 */
	@Override
	public Subscription fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the subscriptions.
	 *
	 * @return the subscriptions
	 */
	@Override
	public List<Subscription> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of subscriptions
	 */
	@Override
	public List<Subscription> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subscriptions
	 */
	@Override
	public List<Subscription> findAll(
		int start, int end, OrderByComparator<Subscription> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subscriptions
	 */
	@Override
	public List<Subscription> findAll(
		int start, int end, OrderByComparator<Subscription> orderByComparator,
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

		List<Subscription> list = null;

		if (useFinderCache) {
			list = (List<Subscription>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SUBSCRIPTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SUBSCRIPTION;

				sql = sql.concat(SubscriptionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Subscription>)QueryUtil.list(
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
	 * Removes all the subscriptions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Subscription subscription : findAll()) {
			remove(subscription);
		}
	}

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SUBSCRIPTION);

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
		return _SQL_SELECT_SUBSCRIPTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SubscriptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the subscription persistence.
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

		_finderPathWithPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setSubscriptionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSubscriptionUtilPersistence(null);

		entityCache.removeCache(SubscriptionImpl.class.getName());
	}

	private void _setSubscriptionUtilPersistence(
		SubscriptionPersistence subscriptionPersistence) {

		try {
			Field field = SubscriptionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, subscriptionPersistence);
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

	private static final String _SQL_SELECT_SUBSCRIPTION =
		"SELECT subscription FROM Subscription subscription";

	private static final String _SQL_SELECT_SUBSCRIPTION_WHERE =
		"SELECT subscription FROM Subscription subscription WHERE ";

	private static final String _SQL_COUNT_SUBSCRIPTION =
		"SELECT COUNT(subscription) FROM Subscription subscription";

	private static final String _SQL_COUNT_SUBSCRIPTION_WHERE =
		"SELECT COUNT(subscription) FROM Subscription subscription WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "subscription.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Subscription exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Subscription exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SubscriptionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}