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

import si.bintegra.sp.model.PackageOffer;

/**
 * The persistence utility for the package offer service. This utility wraps <code>si.bintegra.sp.service.persistence.impl.PackageOfferPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PackageOfferPersistence
 * @generated
 */
public class PackageOfferUtil {

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
	public static void clearCache(PackageOffer packageOffer) {
		getPersistence().clearCache(packageOffer);
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
	public static Map<Serializable, PackageOffer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PackageOffer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PackageOffer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PackageOffer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PackageOffer update(PackageOffer packageOffer) {
		return getPersistence().update(packageOffer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PackageOffer update(
		PackageOffer packageOffer, ServiceContext serviceContext) {

		return getPersistence().update(packageOffer, serviceContext);
	}

	/**
	 * Returns the package offer where id = &#63; or throws a <code>NoSuchPackageOfferException</code> if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public static PackageOffer findByid(long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByid(id);
	}

	/**
	 * Returns the package offer where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByid(long id) {
		return getPersistence().fetchByid(id);
	}

	/**
	 * Returns the package offer where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByid(long id, boolean useFinderCache) {
		return getPersistence().fetchByid(id, useFinderCache);
	}

	/**
	 * Removes the package offer where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the package offer that was removed
	 */
	public static PackageOffer removeByid(long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().removeByid(id);
	}

	/**
	 * Returns the number of package offers where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching package offers
	 */
	public static int countByid(long id) {
		return getPersistence().countByid(id);
	}

	/**
	 * Returns all the package offers where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching package offers
	 */
	public static List<PackageOffer> findByactive(Boolean active) {
		return getPersistence().findByactive(active);
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
	public static List<PackageOffer> findByactive(
		Boolean active, int start, int end) {

		return getPersistence().findByactive(active, start, end);
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
	public static List<PackageOffer> findByactive(
		Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().findByactive(
			active, start, end, orderByComparator);
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
	public static List<PackageOffer> findByactive(
		Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByactive(
			active, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public static PackageOffer findByactive_First(
			Boolean active, OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByactive_First(active, orderByComparator);
	}

	/**
	 * Returns the first package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByactive_First(
		Boolean active, OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().fetchByactive_First(active, orderByComparator);
	}

	/**
	 * Returns the last package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public static PackageOffer findByactive_Last(
			Boolean active, OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByactive_Last(active, orderByComparator);
	}

	/**
	 * Returns the last package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByactive_Last(
		Boolean active, OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().fetchByactive_Last(active, orderByComparator);
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
	public static PackageOffer[] findByactive_PrevAndNext(
			long id, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByactive_PrevAndNext(
			id, active, orderByComparator);
	}

	/**
	 * Removes all the package offers where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public static void removeByactive(Boolean active) {
		getPersistence().removeByactive(active);
	}

	/**
	 * Returns the number of package offers where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching package offers
	 */
	public static int countByactive(Boolean active) {
		return getPersistence().countByactive(active);
	}

	/**
	 * Returns all the package offers where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the matching package offers
	 */
	public static List<PackageOffer> findByofferId(Long offerId) {
		return getPersistence().findByofferId(offerId);
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
	public static List<PackageOffer> findByofferId(
		Long offerId, int start, int end) {

		return getPersistence().findByofferId(offerId, start, end);
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
	public static List<PackageOffer> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().findByofferId(
			offerId, start, end, orderByComparator);
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
	public static List<PackageOffer> findByofferId(
		Long offerId, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByofferId(
			offerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public static PackageOffer findByofferId_First(
			Long offerId, OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByofferId_First(offerId, orderByComparator);
	}

	/**
	 * Returns the first package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByofferId_First(
		Long offerId, OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().fetchByofferId_First(
			offerId, orderByComparator);
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public static PackageOffer findByofferId_Last(
			Long offerId, OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByofferId_Last(offerId, orderByComparator);
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByofferId_Last(
		Long offerId, OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().fetchByofferId_Last(offerId, orderByComparator);
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
	public static PackageOffer[] findByofferId_PrevAndNext(
			long id, Long offerId,
			OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByofferId_PrevAndNext(
			id, offerId, orderByComparator);
	}

	/**
	 * Removes all the package offers where offerId = &#63; from the database.
	 *
	 * @param offerId the offer ID
	 */
	public static void removeByofferId(Long offerId) {
		getPersistence().removeByofferId(offerId);
	}

	/**
	 * Returns the number of package offers where offerId = &#63;.
	 *
	 * @param offerId the offer ID
	 * @return the number of matching package offers
	 */
	public static int countByofferId(Long offerId) {
		return getPersistence().countByofferId(offerId);
	}

	/**
	 * Returns all the package offers where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @return the matching package offers
	 */
	public static List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active) {

		return getPersistence().findByofferIdAndActive(offerId, active);
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
	public static List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active, int start, int end) {

		return getPersistence().findByofferIdAndActive(
			offerId, active, start, end);
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
	public static List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().findByofferIdAndActive(
			offerId, active, start, end, orderByComparator);
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
	public static List<PackageOffer> findByofferIdAndActive(
		Long offerId, Boolean active, int start, int end,
		OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByofferIdAndActive(
			offerId, active, start, end, orderByComparator, useFinderCache);
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
	public static PackageOffer findByofferIdAndActive_First(
			Long offerId, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByofferIdAndActive_First(
			offerId, active, orderByComparator);
	}

	/**
	 * Returns the first package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByofferIdAndActive_First(
		Long offerId, Boolean active,
		OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().fetchByofferIdAndActive_First(
			offerId, active, orderByComparator);
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
	public static PackageOffer findByofferIdAndActive_Last(
			Long offerId, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByofferIdAndActive_Last(
			offerId, active, orderByComparator);
	}

	/**
	 * Returns the last package offer in the ordered set where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public static PackageOffer fetchByofferIdAndActive_Last(
		Long offerId, Boolean active,
		OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().fetchByofferIdAndActive_Last(
			offerId, active, orderByComparator);
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
	public static PackageOffer[] findByofferIdAndActive_PrevAndNext(
			long id, Long offerId, Boolean active,
			OrderByComparator<PackageOffer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByofferIdAndActive_PrevAndNext(
			id, offerId, active, orderByComparator);
	}

	/**
	 * Removes all the package offers where offerId = &#63; and active = &#63; from the database.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 */
	public static void removeByofferIdAndActive(Long offerId, Boolean active) {
		getPersistence().removeByofferIdAndActive(offerId, active);
	}

	/**
	 * Returns the number of package offers where offerId = &#63; and active = &#63;.
	 *
	 * @param offerId the offer ID
	 * @param active the active
	 * @return the number of matching package offers
	 */
	public static int countByofferIdAndActive(Long offerId, Boolean active) {
		return getPersistence().countByofferIdAndActive(offerId, active);
	}

	/**
	 * Caches the package offer in the entity cache if it is enabled.
	 *
	 * @param packageOffer the package offer
	 */
	public static void cacheResult(PackageOffer packageOffer) {
		getPersistence().cacheResult(packageOffer);
	}

	/**
	 * Caches the package offers in the entity cache if it is enabled.
	 *
	 * @param packageOffers the package offers
	 */
	public static void cacheResult(List<PackageOffer> packageOffers) {
		getPersistence().cacheResult(packageOffers);
	}

	/**
	 * Creates a new package offer with the primary key. Does not add the package offer to the database.
	 *
	 * @param id the primary key for the new package offer
	 * @return the new package offer
	 */
	public static PackageOffer create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the package offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer that was removed
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public static PackageOffer remove(long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().remove(id);
	}

	public static PackageOffer updateImpl(PackageOffer packageOffer) {
		return getPersistence().updateImpl(packageOffer);
	}

	/**
	 * Returns the package offer with the primary key or throws a <code>NoSuchPackageOfferException</code> if it could not be found.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public static PackageOffer findByPrimaryKey(long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the package offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer, or <code>null</code> if a package offer with the primary key could not be found
	 */
	public static PackageOffer fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the package offers.
	 *
	 * @return the package offers
	 */
	public static List<PackageOffer> findAll() {
		return getPersistence().findAll();
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
	public static List<PackageOffer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<PackageOffer> findAll(
		int start, int end, OrderByComparator<PackageOffer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<PackageOffer> findAll(
		int start, int end, OrderByComparator<PackageOffer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the package offers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of package offers.
	 *
	 * @return the number of package offers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PackageOfferPersistence getPersistence() {
		return _persistence;
	}

	private static volatile PackageOfferPersistence _persistence;

}