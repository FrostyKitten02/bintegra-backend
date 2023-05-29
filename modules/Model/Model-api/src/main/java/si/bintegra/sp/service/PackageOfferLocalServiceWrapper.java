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

package si.bintegra.sp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PackageOfferLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PackageOfferLocalService
 * @generated
 */
public class PackageOfferLocalServiceWrapper
	implements PackageOfferLocalService,
			   ServiceWrapper<PackageOfferLocalService> {

	public PackageOfferLocalServiceWrapper() {
		this(null);
	}

	public PackageOfferLocalServiceWrapper(
		PackageOfferLocalService packageOfferLocalService) {

		_packageOfferLocalService = packageOfferLocalService;
	}

	/**
	 * Adds the package offer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PackageOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param packageOffer the package offer
	 * @return the package offer that was added
	 */
	@Override
	public si.bintegra.sp.model.PackageOffer addPackageOffer(
		si.bintegra.sp.model.PackageOffer packageOffer) {

		return _packageOfferLocalService.addPackageOffer(packageOffer);
	}

	/**
	 * Creates a new package offer with the primary key. Does not add the package offer to the database.
	 *
	 * @param id the primary key for the new package offer
	 * @return the new package offer
	 */
	@Override
	public si.bintegra.sp.model.PackageOffer createPackageOffer(long id) {
		return _packageOfferLocalService.createPackageOffer(id);
	}

	@Override
	public si.bintegra.sp.model.PackageOffer createPackageOffer(
			Long offerId, Long fullDuration, Long discountDuration,
			Double discountPrice, Double basePrice, Boolean active)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return _packageOfferLocalService.createPackageOffer(
			offerId, fullDuration, discountDuration, discountPrice, basePrice,
			active);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _packageOfferLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the package offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PackageOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer that was removed
	 * @throws PortalException if a package offer with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.PackageOffer deletePackageOffer(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _packageOfferLocalService.deletePackageOffer(id);
	}

	/**
	 * Deletes the package offer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PackageOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param packageOffer the package offer
	 * @return the package offer that was removed
	 */
	@Override
	public si.bintegra.sp.model.PackageOffer deletePackageOffer(
		si.bintegra.sp.model.PackageOffer packageOffer) {

		return _packageOfferLocalService.deletePackageOffer(packageOffer);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _packageOfferLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _packageOfferLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _packageOfferLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _packageOfferLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _packageOfferLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _packageOfferLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _packageOfferLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _packageOfferLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _packageOfferLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public si.bintegra.sp.model.PackageOffer fetchPackageOffer(long id) {
		return _packageOfferLocalService.fetchPackageOffer(id);
	}

	@Override
	public java.util.List<si.bintegra.sp.model.PackageOffer>
		findActiveByOfferId(Long id) {

		return _packageOfferLocalService.findActiveByOfferId(id);
	}

	@Override
	public java.util.List
		<com.sun.tools.javac.util.Pair
			<si.bintegra.sp.model.Offer, si.bintegra.sp.model.PackageOffer>>
					findActiveByOfferType(String type)
				throws si.bintegra.sp.exception.NoSuchOfferException {

		return _packageOfferLocalService.findActiveByOfferType(type);
	}

	@Override
	public si.bintegra.sp.model.PackageOffer findById(Long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		return _packageOfferLocalService.findById(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _packageOfferLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _packageOfferLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _packageOfferLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the package offer with the primary key.
	 *
	 * @param id the primary key of the package offer
	 * @return the package offer
	 * @throws PortalException if a package offer with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.PackageOffer getPackageOffer(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _packageOfferLocalService.getPackageOffer(id);
	}

	/**
	 * Returns a range of all the package offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.PackageOfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of package offers
	 * @param end the upper bound of the range of package offers (not inclusive)
	 * @return the range of package offers
	 */
	@Override
	public java.util.List<si.bintegra.sp.model.PackageOffer> getPackageOffers(
		int start, int end) {

		return _packageOfferLocalService.getPackageOffers(start, end);
	}

	/**
	 * Returns the number of package offers.
	 *
	 * @return the number of package offers
	 */
	@Override
	public int getPackageOffersCount() {
		return _packageOfferLocalService.getPackageOffersCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _packageOfferLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the package offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PackageOfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param packageOffer the package offer
	 * @return the package offer that was updated
	 */
	@Override
	public si.bintegra.sp.model.PackageOffer updatePackageOffer(
		si.bintegra.sp.model.PackageOffer packageOffer) {

		return _packageOfferLocalService.updatePackageOffer(packageOffer);
	}

	@Override
	public PackageOfferLocalService getWrappedService() {
		return _packageOfferLocalService;
	}

	@Override
	public void setWrappedService(
		PackageOfferLocalService packageOfferLocalService) {

		_packageOfferLocalService = packageOfferLocalService;
	}

	private PackageOfferLocalService _packageOfferLocalService;

}