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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.PackageOffer;

/**
 * The persistence interface for the package offer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PackageOfferUtil
 * @generated
 */
@ProviderType
public interface PackageOfferPersistence extends BasePersistence<PackageOffer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PackageOfferUtil} to access the package offer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the package offers where active = &#63;.
	 *
	 * @param active the active
	 * @return the matching package offers
	 */
	public java.util.List<PackageOffer> findByactive(boolean active);

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
	public java.util.List<PackageOffer> findByactive(
		boolean active, int start, int end);

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
	public java.util.List<PackageOffer> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

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
	public java.util.List<PackageOffer> findByactive(
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public PackageOffer findByactive_First(
			boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the first package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public PackageOffer fetchByactive_First(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns the last package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public PackageOffer findByactive_Last(
			boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the last package offer in the ordered set where active = &#63;.
	 *
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public PackageOffer fetchByactive_Last(
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns the package offers before and after the current package offer in the ordered set where active = &#63;.
	 *
	 * @param id the primary key of the current package offer
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public PackageOffer[] findByactive_PrevAndNext(
			long id, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Removes all the package offers where active = &#63; from the database.
	 *
	 * @param active the active
	 */
	public void removeByactive(boolean active);

	/**
	 * Returns the number of package offers where active = &#63;.
	 *
	 * @param active the active
	 * @return the number of matching package offers
	 */
	public int countByactive(boolean active);

	/**
	 * Returns all the package offers where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageId(long packageId);

	/**
	 * Returns a range of all the package offers where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageId(
		long packageId, int start, int end);

	/**
	 * Returns an ordered range of all the package offers where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageId(
		long packageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the package offers where packageId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageId(
		long packageId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first package offer in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public PackageOffer findBypackageId_First(
			long packageId,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the first package offer in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public PackageOffer fetchBypackageId_First(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns the last package offer in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public PackageOffer findBypackageId_Last(
			long packageId,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the last package offer in the ordered set where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public PackageOffer fetchBypackageId_Last(
		long packageId,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns the package offers before and after the current package offer in the ordered set where packageId = &#63;.
	 *
	 * @param id the primary key of the current package offer
	 * @param packageId the package ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public PackageOffer[] findBypackageId_PrevAndNext(
			long id, long packageId,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Removes all the package offers where packageId = &#63; from the database.
	 *
	 * @param packageId the package ID
	 */
	public void removeBypackageId(long packageId);

	/**
	 * Returns the number of package offers where packageId = &#63;.
	 *
	 * @param packageId the package ID
	 * @return the number of matching package offers
	 */
	public int countBypackageId(long packageId);

	/**
	 * Returns all the package offers where packageId = &#63; and active = &#63;.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @return the matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageIdAndActive(
		long packageId, boolean active);

	/**
	 * Returns a range of all the package offers where packageId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageIdAndActive(
		long packageId, boolean active, int start, int end);

	/**
	 * Returns an ordered range of all the package offers where packageId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageIdAndActive(
		long packageId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns an ordered range of all the package offers where packageId = &#63; and active = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching package offers
	 */
	public java.util.List<PackageOffer> findBypackageIdAndActive(
		long packageId, boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first package offer in the ordered set where packageId = &#63; and active = &#63;.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public PackageOffer findBypackageIdAndActive_First(
			long packageId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the first package offer in the ordered set where packageId = &#63; and active = &#63;.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public PackageOffer fetchBypackageIdAndActive_First(
		long packageId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns the last package offer in the ordered set where packageId = &#63; and active = &#63;.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer
	 * @throws NoSuchPackageOfferException if a matching package offer could not be found
	 */
	public PackageOffer findBypackageIdAndActive_Last(
			long packageId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the last package offer in the ordered set where packageId = &#63; and active = &#63;.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching package offer, or <code>null</code> if a matching package offer could not be found
	 */
	public PackageOffer fetchBypackageIdAndActive_Last(
		long packageId, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

	/**
	 * Returns the package offers before and after the current package offer in the ordered set where packageId = &#63; and active = &#63;.
	 *
	 * @param id the primary key of the current package offer
	 * @param packageId the package ID
	 * @param active the active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public PackageOffer[] findBypackageIdAndActive_PrevAndNext(
			long id, long packageId, boolean active,
			com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
				orderByComparator)
		throws NoSuchPackageOfferException;

	/**
	 * Removes all the package offers where packageId = &#63; and active = &#63; from the database.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 */
	public void removeBypackageIdAndActive(long packageId, boolean active);

	/**
	 * Returns the number of package offers where packageId = &#63; and active = &#63;.
	 *
	 * @param packageId the package ID
	 * @param active the active
	 * @return the number of matching package offers
	 */
	public int countBypackageIdAndActive(long packageId, boolean active);

	/**
	 * Caches the package offer in the entity cache if it is enabled.
	 *
	 * @param packageOffer the package offer
	 */
	public void cacheResult(PackageOffer packageOffer);

	/**
	 * Caches the package offers in the entity cache if it is enabled.
	 *
	 * @param packageOffers the package offers
	 */
	public void cacheResult(java.util.List<PackageOffer> packageOffers);

	/**
	 * Creates a new package offer with the primary key. Does not add the package offer to the database.
	 *
	 * @param id the primary key for the new package offer
	 * @return the new package offer
	 */
	public PackageOffer create(long id);

	/**
	 * Removes the package offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer that was removed
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public PackageOffer remove(long id) throws NoSuchPackageOfferException;

	public PackageOffer updateImpl(PackageOffer packageOffer);

	/**
	 * Returns the package offer with the primary key or throws a <code>NoSuchPackageOfferException</code> if it could not be found.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer
	 * @throws NoSuchPackageOfferException if a package offer with the primary key could not be found
	 */
	public PackageOffer findByPrimaryKey(long id)
		throws NoSuchPackageOfferException;

	/**
	 * Returns the package offer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer, or <code>null</code> if a package offer with the primary key could not be found
	 */
	public PackageOffer fetchByPrimaryKey(long id);

	/**
	 * Returns all the package offers.
	 *
	 * @return the package offers
	 */
	public java.util.List<PackageOffer> findAll();

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
	public java.util.List<PackageOffer> findAll(int start, int end);

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
	public java.util.List<PackageOffer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator);

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
	public java.util.List<PackageOffer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PackageOffer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the package offers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of package offers.
	 *
	 * @return the number of package offers
	 */
	public int countAll();

}