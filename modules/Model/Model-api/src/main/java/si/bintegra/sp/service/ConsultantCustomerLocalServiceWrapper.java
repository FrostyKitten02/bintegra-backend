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
 * Provides a wrapper for {@link ConsultantCustomerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantCustomerLocalService
 * @generated
 */
public class ConsultantCustomerLocalServiceWrapper
	implements ConsultantCustomerLocalService,
			   ServiceWrapper<ConsultantCustomerLocalService> {

	public ConsultantCustomerLocalServiceWrapper() {
		this(null);
	}

	public ConsultantCustomerLocalServiceWrapper(
		ConsultantCustomerLocalService consultantCustomerLocalService) {

		_consultantCustomerLocalService = consultantCustomerLocalService;
	}

	/**
	 * Adds the consultant customer to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consultantCustomer the consultant customer
	 * @return the consultant customer that was added
	 */
	@Override
	public si.bintegra.sp.model.ConsultantCustomer addConsultantCustomer(
		si.bintegra.sp.model.ConsultantCustomer consultantCustomer) {

		return _consultantCustomerLocalService.addConsultantCustomer(
			consultantCustomer);
	}

	@Override
	public void assignConsultantToCustomer(Long customerUserId) {
		_consultantCustomerLocalService.assignConsultantToCustomer(
			customerUserId);
	}

	/**
	 * Creates a new consultant customer with the primary key. Does not add the consultant customer to the database.
	 *
	 * @param id the primary key for the new consultant customer
	 * @return the new consultant customer
	 */
	@Override
	public si.bintegra.sp.model.ConsultantCustomer createConsultantCustomer(
		long id) {

		return _consultantCustomerLocalService.createConsultantCustomer(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantCustomerLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the consultant customer from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consultantCustomer the consultant customer
	 * @return the consultant customer that was removed
	 */
	@Override
	public si.bintegra.sp.model.ConsultantCustomer deleteConsultantCustomer(
		si.bintegra.sp.model.ConsultantCustomer consultantCustomer) {

		return _consultantCustomerLocalService.deleteConsultantCustomer(
			consultantCustomer);
	}

	/**
	 * Deletes the consultant customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer that was removed
	 * @throws PortalException if a consultant customer with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.ConsultantCustomer deleteConsultantCustomer(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantCustomerLocalService.deleteConsultantCustomer(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantCustomerLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _consultantCustomerLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _consultantCustomerLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _consultantCustomerLocalService.dynamicQuery();
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

		return _consultantCustomerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.ConsultantCustomerModelImpl</code>.
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

		return _consultantCustomerLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.ConsultantCustomerModelImpl</code>.
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

		return _consultantCustomerLocalService.dynamicQuery(
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

		return _consultantCustomerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _consultantCustomerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public si.bintegra.sp.model.ConsultantCustomer fetchConsultantCustomer(
		long id) {

		return _consultantCustomerLocalService.fetchConsultantCustomer(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _consultantCustomerLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the consultant customer with the primary key.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer
	 * @throws PortalException if a consultant customer with the primary key could not be found
	 */
	@Override
	public si.bintegra.sp.model.ConsultantCustomer getConsultantCustomer(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantCustomerLocalService.getConsultantCustomer(id);
	}

	/**
	 * Returns a range of all the consultant customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>si.bintegra.sp.model.impl.ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @return the range of consultant customers
	 */
	@Override
	public java.util.List<si.bintegra.sp.model.ConsultantCustomer>
		getConsultantCustomers(int start, int end) {

		return _consultantCustomerLocalService.getConsultantCustomers(
			start, end);
	}

	/**
	 * Returns the number of consultant customers.
	 *
	 * @return the number of consultant customers
	 */
	@Override
	public int getConsultantCustomersCount() {
		return _consultantCustomerLocalService.getConsultantCustomersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _consultantCustomerLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _consultantCustomerLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _consultantCustomerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the consultant customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ConsultantCustomerLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param consultantCustomer the consultant customer
	 * @return the consultant customer that was updated
	 */
	@Override
	public si.bintegra.sp.model.ConsultantCustomer updateConsultantCustomer(
		si.bintegra.sp.model.ConsultantCustomer consultantCustomer) {

		return _consultantCustomerLocalService.updateConsultantCustomer(
			consultantCustomer);
	}

	@Override
	public ConsultantCustomerLocalService getWrappedService() {
		return _consultantCustomerLocalService;
	}

	@Override
	public void setWrappedService(
		ConsultantCustomerLocalService consultantCustomerLocalService) {

		_consultantCustomerLocalService = consultantCustomerLocalService;
	}

	private ConsultantCustomerLocalService _consultantCustomerLocalService;

}