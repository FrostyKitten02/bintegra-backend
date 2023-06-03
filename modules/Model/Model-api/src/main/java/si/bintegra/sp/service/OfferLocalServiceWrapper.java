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
 * Provides a wrapper for {@link OfferLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OfferLocalService
 * @generated
 */
public class OfferLocalServiceWrapper
	implements OfferLocalService, ServiceWrapper<OfferLocalService> {

	public OfferLocalServiceWrapper() {
		this(null);
	}

	public OfferLocalServiceWrapper(OfferLocalService offerLocalService) {
		_offerLocalService = offerLocalService;
	}

	/**
	 * Adds the offer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was added
	 */
	@Override
	public si.bintegra.sp.model.Offer addOffer(
		si.bintegra.sp.model.Offer offer) {

		return _offerLocalService.addOffer(offer);
	}

	@Override
	public si.bintegra.sp.model.Offer addOffer(
		String title, String type, String description, Boolean active,
		Long mobileData, Long mobileMinutes, Long mobileSms,
		Long programsNumber, Long defaultNumberOfTvs, Long downloadSpeed,
		Long uploadSpeed, Long fullDurationMonths, Long discountDurationMonths,
		Double basePrice, Double discountPrice) {

		return _offerLocalService.addOffer(
			title, type, description, active, mobileData, mobileMinutes,
			mobileSms, programsNumber, defaultNumberOfTvs, downloadSpeed,
			uploadSpeed, fullDurationMonths, discountDurationMonths, basePrice,
			discountPrice);
	}

	/**
	 * Creates a new offer with the primary key. Does not add the offer to the database.
	 *
	 * @param id the primary key for the new offer
	 * @return the new offer
	 */
	@Override
	public si.bintegra.sp.model.Offer createOffer(long id) {
		return _offerLocalService.createOffer(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the offer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the offer
	 * @return the offer that was removed
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.Offer deleteOffer(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.deleteOffer(id);
	}

	/**
	 * Deletes the offer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was removed
	 */
	@Override
	public si.bintegra.sp.model.Offer deleteOffer(
		si.bintegra.sp.model.Offer offer) {

		return _offerLocalService.deleteOffer(offer);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _offerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _offerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _offerLocalService.dynamicQuery();
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

		return _offerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.OfferModelImpl</code>.
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

		return _offerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.OfferModelImpl</code>.
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

		return _offerLocalService.dynamicQuery(
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

		return _offerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _offerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public si.bintegra.sp.model.Offer fetchOffer(long id) {
		return _offerLocalService.fetchOffer(id);
	}

	@Override
	public java.util.List<si.bintegra.sp.model.Offer> findActiveByType(
		String type) {

		return _offerLocalService.findActiveByType(type);
	}

	@Override
	public si.bintegra.sp.model.Offer findById(long id)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		return _offerLocalService.findById(id);
	}

	@Override
	public java.util.List<si.bintegra.sp.model.Offer> findByType(String type) {
		return _offerLocalService.findByType(type);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _offerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _offerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the offer with the primary key.
	 *
	 * @param id the primary key of the offer
	 * @return the offer
	 * @throws PortalException if a offer with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.Offer getOffer(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.getOffer(id);
	}

	/**
	 * Returns a range of all the offers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.OfferModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offers
	 * @param end the upper bound of the range of offers (not inclusive)
	 * @return the range of offers
	 */
	@Override
	public java.util.List<si.bintegra.sp.model.Offer> getOffers(
		int start, int end) {

		return _offerLocalService.getOffers(start, end);
	}

	/**
	 * Returns the number of offers.
	 *
	 * @return the number of offers
	 */
	@Override
	public int getOffersCount() {
		return _offerLocalService.getOffersCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the offer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OfferLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offer the offer
	 * @return the offer that was updated
	 */
	@Override
	public si.bintegra.sp.model.Offer updateOffer(
		si.bintegra.sp.model.Offer offer) {

		return _offerLocalService.updateOffer(offer);
	}

	@Override
	public OfferLocalService getWrappedService() {
		return _offerLocalService;
	}

	@Override
	public void setWrappedService(OfferLocalService offerLocalService) {
		_offerLocalService = offerLocalService;
	}

	private OfferLocalService _offerLocalService;

}