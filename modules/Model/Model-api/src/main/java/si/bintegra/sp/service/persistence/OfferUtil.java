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

import si.bintegra.sp.model.Offer;

/**
 * The persistence utility for the offer service. This utility wraps <code>si.bintegra.sp.service.persistence.impl.OfferPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfferPersistence
 * @generated
 */
public class OfferUtil {

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
	public static void clearCache(Offer offer) {
		getPersistence().clearCache(offer);
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
	public static Map<Serializable, Offer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Offer> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Offer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Offer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Offer update(Offer offer) {
		return getPersistence().update(offer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Offer update(Offer offer, ServiceContext serviceContext) {
		return getPersistence().update(offer, serviceContext);
	}

	/**
	 * Returns all the offers where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching offers
	 */
	public static List<Offer> findBytype(String type) {
		return getPersistence().findBytype(type);
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
	public static List<Offer> findBytype(String type, int start, int end) {
		return getPersistence().findBytype(type, start, end);
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
	public static List<Offer> findBytype(
		String type, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findBytype(type, start, end, orderByComparator);
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
	public static List<Offer> findBytype(
		String type, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytype(
			type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findBytype_First(
			String type, OrderByComparator<Offer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findBytype_First(type, orderByComparator);
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchBytype_First(
		String type, OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchBytype_First(type, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer
	 * @throws NoSuchOfferException if a matching offer could not be found
	 */
	public static Offer findBytype_Last(
			String type, OrderByComparator<Offer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findBytype_Last(type, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchBytype_Last(
		String type, OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchBytype_Last(type, orderByComparator);
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
	public static Offer[] findBytype_PrevAndNext(
			long id, String type, OrderByComparator<Offer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findBytype_PrevAndNext(
			id, type, orderByComparator);
	}

	/**
	 * Removes all the offers where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public static void removeBytype(String type) {
		getPersistence().removeBytype(type);
	}

	/**
	 * Returns the number of offers where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching offers
	 */
	public static int countBytype(String type) {
		return getPersistence().countBytype(type);
	}

	/**
	 * Returns all the offers where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @return the matching offers
	 */
	public static List<Offer> findBytypeAndActive(String type, Boolean active) {
		return getPersistence().findBytypeAndActive(type, active);
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
	public static List<Offer> findBytypeAndActive(
		String type, Boolean active, int start, int end) {

		return getPersistence().findBytypeAndActive(type, active, start, end);
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
	public static List<Offer> findBytypeAndActive(
		String type, Boolean active, int start, int end,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findBytypeAndActive(
			type, active, start, end, orderByComparator);
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
	public static List<Offer> findBytypeAndActive(
		String type, Boolean active, int start, int end,
		OrderByComparator<Offer> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBytypeAndActive(
			type, active, start, end, orderByComparator, useFinderCache);
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
	public static Offer findBytypeAndActive_First(
			String type, Boolean active,
			OrderByComparator<Offer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findBytypeAndActive_First(
			type, active, orderByComparator);
	}

	/**
	 * Returns the first offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchBytypeAndActive_First(
		String type, Boolean active,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchBytypeAndActive_First(
			type, active, orderByComparator);
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
	public static Offer findBytypeAndActive_Last(
			String type, Boolean active,
			OrderByComparator<Offer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findBytypeAndActive_Last(
			type, active, orderByComparator);
	}

	/**
	 * Returns the last offer in the ordered set where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offer, or <code>null</code> if a matching offer could not be found
	 */
	public static Offer fetchBytypeAndActive_Last(
		String type, Boolean active,
		OrderByComparator<Offer> orderByComparator) {

		return getPersistence().fetchBytypeAndActive_Last(
			type, active, orderByComparator);
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
	public static Offer[] findBytypeAndActive_PrevAndNext(
			long id, String type, Boolean active,
			OrderByComparator<Offer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findBytypeAndActive_PrevAndNext(
			id, type, active, orderByComparator);
	}

	/**
	 * Removes all the offers where type = &#63; and active = &#63; from the database.
	 *
	 * @param type the type
	 * @param active the active
	 */
	public static void removeBytypeAndActive(String type, Boolean active) {
		getPersistence().removeBytypeAndActive(type, active);
	}

	/**
	 * Returns the number of offers where type = &#63; and active = &#63;.
	 *
	 * @param type the type
	 * @param active the active
	 * @return the number of matching offers
	 */
	public static int countBytypeAndActive(String type, Boolean active) {
		return getPersistence().countBytypeAndActive(type, active);
	}

	/**
	 * Caches the offer in the entity cache if it is enabled.
	 *
	 * @param offer the offer
	 */
	public static void cacheResult(Offer offer) {
		getPersistence().cacheResult(offer);
	}

	/**
	 * Caches the offers in the entity cache if it is enabled.
	 *
	 * @param offers the offers
	 */
	public static void cacheResult(List<Offer> offers) {
		getPersistence().cacheResult(offers);
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param id the primary key for the new offer
	 * @return the new offer
	 */
	public static Offer create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the offer
	 * @return the offer that was removed
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer remove(long id)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().remove(id);
	}

	public static Offer updateImpl(Offer offer) {
		return getPersistence().updateImpl(offer);
	}

	/**
	 * Returns the offer with the primary key or throws a <code>NoSuchOfferException</code> if it could not be found.
	 *
	 * @param id the primary key of the offer
	 * @return the offer
	 * @throws NoSuchOfferException if a offer with the primary key could not be found
	 */
	public static Offer findByPrimaryKey(long id)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the offer
	 * @return the offer, or <code>null</code> if a offer with the primary key could not be found
	 */
	public static Offer fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the offers.
	 *
	 * @return the offers
	 */
	public static List<Offer> findAll() {
		return getPersistence().findAll();
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
	public static List<Offer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Offer> findAll(
		int start, int end, OrderByComparator<Offer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Offer> findAll(
		int start, int end, OrderByComparator<Offer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the offers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OfferPersistence getPersistence() {
		return _persistence;
	}

	private static volatile OfferPersistence _persistence;

}