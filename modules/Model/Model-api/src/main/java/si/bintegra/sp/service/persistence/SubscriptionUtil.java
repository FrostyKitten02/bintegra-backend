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

package si.bintegra.sp.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import si.bintegra.sp.model.Subscription;

/**
 * The persistence utility for the subscription service. This utility wraps <code>si.bintegra.sp.service.persistence.impl.SubscriptionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionPersistence
 * @generated
 */
public class SubscriptionUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Subscription subscription) {
		getPersistence().clearCache(subscription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Subscription> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Subscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Subscription update(Subscription subscription) {
		return getPersistence().update(subscription);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Subscription update(
		Subscription subscription, ServiceContext serviceContext) {

		return getPersistence().update(subscription, serviceContext);
	}

	/**
	 * Returns all the subscriptions where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the matching subscriptions
	 */
	public static List<Subscription> findByofferId(Long offerId) {
		return getPersistence().findByofferId(offerId);
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
	public static List<Subscription> findByofferId(
		Long offerId, int start, int end) {

		return getPersistence().findByofferId(offerId, start, end);
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
	public static List<Subscription> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().findByofferId(
			offerId, start, end, orderByComparator);
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
	public static List<Subscription> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<Subscription> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByofferId(
			offerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public static Subscription findByofferId_First(
			Long offerId, OrderByComparator<Subscription> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByofferId_First(offerId, orderByComparator);
	}

	/**
	 * Returns the first subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public static Subscription fetchByofferId_First(
		Long offerId, OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().fetchByofferId_First(
			offerId, orderByComparator);
	}

	/**
	 * Returns the last subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public static Subscription findByofferId_Last(
			Long offerId, OrderByComparator<Subscription> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByofferId_Last(offerId, orderByComparator);
	}

	/**
	 * Returns the last subscription in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public static Subscription fetchByofferId_Last(
		Long offerId, OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().fetchByofferId_Last(offerId, orderByComparator);
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
	public static Subscription[] findByofferId_PrevAndNext(
			long id, Long offerId,
			OrderByComparator<Subscription> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByofferId_PrevAndNext(
			id, offerId, orderByComparator);
	}

	/**
	 * Removes all the subscriptions where offerId = &#63; from the database.
	 *
	 * @param offerId the offer ID
	 */
	public static void removeByofferId(Long offerId) {
		getPersistence().removeByofferId(offerId);
	}

	/**
	 * Returns the number of subscriptions where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the number of matching subscriptions
	 */
	public static int countByofferId(Long offerId) {
		return getPersistence().countByofferId(offerId);
	}

	/**
	 * Returns all the subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching subscriptions
	 */
	public static List<Subscription> findByuserId(Long userId) {
		return getPersistence().findByuserId(userId);
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
	public static List<Subscription> findByuserId(
		Long userId, int start, int end) {

		return getPersistence().findByuserId(userId, start, end);
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
	public static List<Subscription> findByuserId(
		Long userId, int start, int end,
		OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator);
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
	public static List<Subscription> findByuserId(
		Long userId, int start, int end,
		OrderByComparator<Subscription> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByuserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public static Subscription findByuserId_First(
			Long userId, OrderByComparator<Subscription> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public static Subscription fetchByuserId_First(
		Long userId, OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public static Subscription findByuserId_Last(
			Long userId, OrderByComparator<Subscription> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last subscription in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public static Subscription fetchByuserId_Last(
		Long userId, OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
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
	public static Subscription[] findByuserId_PrevAndNext(
			long id, Long userId,
			OrderByComparator<Subscription> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByuserId_PrevAndNext(
			id, userId, orderByComparator);
	}

	/**
	 * Removes all the subscriptions where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByuserId(Long userId) {
		getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of subscriptions where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching subscriptions
	 */
	public static int countByuserId(Long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the subscription in the entity cache if it is enabled.
	 *
	 * @param subscription the subscription
	 */
	public static void cacheResult(Subscription subscription) {
		getPersistence().cacheResult(subscription);
	}

	/**
	 * Caches the subscriptions in the entity cache if it is enabled.
	 *
	 * @param subscriptions the subscriptions
	 */
	public static void cacheResult(List<Subscription> subscriptions) {
		getPersistence().cacheResult(subscriptions);
	}

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param id the primary key for the new subscription
	 * @return the new subscription
	 */
	public static Subscription create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public static Subscription remove(long id)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().remove(id);
	}

	public static Subscription updateImpl(Subscription subscription) {
		return getPersistence().updateImpl(subscription);
	}

	/**
	 * Returns the subscription with the primary key or throws a <code>NoSuchSubscriptionException</code> if it could not be found.
	 *
	 * @param id the primary key of the subscription
	 * @return the subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public static Subscription findByPrimaryKey(long id)
		throws si.bintegra.sp.exception.NoSuchSubscriptionException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the subscription
	 * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	 */
	public static Subscription fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the subscriptions.
	 *
	 * @return the subscriptions
	 */
	public static List<Subscription> findAll() {
		return getPersistence().findAll();
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
	public static List<Subscription> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Subscription> findAll(
		int start, int end, OrderByComparator<Subscription> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Subscription> findAll(
		int start, int end, OrderByComparator<Subscription> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the subscriptions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SubscriptionPersistence getPersistence() {
		return _persistence;
	}

	private static volatile SubscriptionPersistence _persistence;

}