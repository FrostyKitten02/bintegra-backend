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
 * Provides a wrapper for {@link ConsultantLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantLocalService
 * @generated
 */
public class ConsultantLocalServiceWrapper
	implements ConsultantLocalService, ServiceWrapper<ConsultantLocalService> {

	public ConsultantLocalServiceWrapper() {
		this(null);
	}

	public ConsultantLocalServiceWrapper(
		ConsultantLocalService consultantLocalService) {

		_consultantLocalService = consultantLocalService;
	}

	/**
	 * Adds the consultant to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consultant the consultant
	 * @return the consultant that was added
	 */
	@Override
	public si.bintegra.sp.model.Consultant addConsultant(
		si.bintegra.sp.model.Consultant consultant) {

		return _consultantLocalService.addConsultant(consultant);
	}

	@Override
	public void addConsultant(Long userId) {
		_consultantLocalService.addConsultant(userId);
	}

	/**
	 * Creates a new consultant with the primary key. Does not add the consultant to the database.
	 *
	 * @param id the primary key for the new consultant
	 * @return the new consultant
	 */
	@Override
	public si.bintegra.sp.model.Consultant createConsultant(long id) {
		return _consultantLocalService.createConsultant(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the consultant from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consultant the consultant
	 * @return the consultant that was removed
	 */
	@Override
	public si.bintegra.sp.model.Consultant deleteConsultant(
		si.bintegra.sp.model.Consultant consultant) {

		return _consultantLocalService.deleteConsultant(consultant);
	}

	/**
	 * Deletes the consultant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant that was removed
	 * @throws PortalException if a consultant with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.Consultant deleteConsultant(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantLocalService.deleteConsultant(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _consultantLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _consultantLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _consultantLocalService.dynamicQuery();
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

		return _consultantLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.ConsultantModelImpl</code>.
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

		return _consultantLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.ConsultantModelImpl</code>.
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

		return _consultantLocalService.dynamicQuery(
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

		return _consultantLocalService.dynamicQueryCount(dynamicQuery);
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

		return _consultantLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public si.bintegra.sp.model.Consultant fetchConsultant(long id) {
		return _consultantLocalService.fetchConsultant(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _consultantLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<si.bintegra.sp.model.Consultant> getAllConsultants() {
		return _consultantLocalService.getAllConsultants();
	}

	/**
	 * Returns the consultant with the primary key.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant
	 * @throws PortalException if a consultant with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.Consultant getConsultant(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantLocalService.getConsultant(id);
	}

	@Override
	public si.bintegra.sp.model.Consultant getConsultantByUserId(Long userId) {
		return _consultantLocalService.getConsultantByUserId(userId);
	}

	/**
	 * Returns a range of all the consultants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.ConsultantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultants
	 * @param end the upper bound of the range of consultants (not inclusive)
	 * @return the range of consultants
	 */
	@Override
	public java.util.List<si.bintegra.sp.model.Consultant> getConsultants(
		int start, int end) {

		return _consultantLocalService.getConsultants(start, end);
	}

	/**
	 * Returns the number of consultants.
	 *
	 * @return the number of consultants
	 */
	@Override
	public int getConsultantsCount() {
		return _consultantLocalService.getConsultantsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _consultantLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _consultantLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the consultant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consultant the consultant
	 * @return the consultant that was updated
	 */
	@Override
	public si.bintegra.sp.model.Consultant updateConsultant(
		si.bintegra.sp.model.Consultant consultant) {

		return _consultantLocalService.updateConsultant(consultant);
	}

	@Override
	public ConsultantLocalService getWrappedService() {
		return _consultantLocalService;
	}

	@Override
	public void setWrappedService(
		ConsultantLocalService consultantLocalService) {

		_consultantLocalService = consultantLocalService;
	}

	private ConsultantLocalService _consultantLocalService;

}