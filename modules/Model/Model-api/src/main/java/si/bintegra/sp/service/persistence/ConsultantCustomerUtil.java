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

import si.bintegra.sp.model.ConsultantCustomer;

/**
 * The persistence utility for the consultant customer service. This utility wraps <code>si.bintegra.sp.service.persistence.impl.ConsultantCustomerPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantCustomerPersistence
 * @generated
 */
public class ConsultantCustomerUtil {

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
	public static void clearCache(ConsultantCustomer consultantCustomer) {
		getPersistence().clearCache(consultantCustomer);
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
	public static Map<Serializable, ConsultantCustomer> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ConsultantCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConsultantCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConsultantCustomer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ConsultantCustomer update(
		ConsultantCustomer consultantCustomer) {

		return getPersistence().update(consultantCustomer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ConsultantCustomer update(
		ConsultantCustomer consultantCustomer, ServiceContext serviceContext) {

		return getPersistence().update(consultantCustomer, serviceContext);
	}

	/**
	 * Returns all the consultant customers where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @return the matching consultant customers
	 */
	public static List<ConsultantCustomer> findByconsultantId(
		Long consultantId) {

		return getPersistence().findByconsultantId(consultantId);
	}

	/**
	 * Returns a range of all the consultant customers where consultantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param consultantId the consultant ID
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @return the range of matching consultant customers
	 */
	public static List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end) {

		return getPersistence().findByconsultantId(consultantId, start, end);
	}

	/**
	 * Returns an ordered range of all the consultant customers where consultantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param consultantId the consultant ID
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consultant customers
	 */
	public static List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().findByconsultantId(
			consultantId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the consultant customers where consultantId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param consultantId the consultant ID
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consultant customers
	 */
	public static List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByconsultantId(
			consultantId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer findByconsultantId_First(
			Long consultantId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findByconsultantId_First(
			consultantId, orderByComparator);
	}

	/**
	 * Returns the first consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer fetchByconsultantId_First(
		Long consultantId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().fetchByconsultantId_First(
			consultantId, orderByComparator);
	}

	/**
	 * Returns the last consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer findByconsultantId_Last(
			Long consultantId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findByconsultantId_Last(
			consultantId, orderByComparator);
	}

	/**
	 * Returns the last consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer fetchByconsultantId_Last(
		Long consultantId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().fetchByconsultantId_Last(
			consultantId, orderByComparator);
	}

	/**
	 * Returns the consultant customers before and after the current consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param id the primary key of the current consultant customer
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public static ConsultantCustomer[] findByconsultantId_PrevAndNext(
			long id, Long consultantId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findByconsultantId_PrevAndNext(
			id, consultantId, orderByComparator);
	}

	/**
	 * Removes all the consultant customers where consultantId = &#63; from the database.
	 *
	 * @param consultantId the consultant ID
	 */
	public static void removeByconsultantId(Long consultantId) {
		getPersistence().removeByconsultantId(consultantId);
	}

	/**
	 * Returns the number of consultant customers where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @return the number of matching consultant customers
	 */
	public static int countByconsultantId(Long consultantId) {
		return getPersistence().countByconsultantId(consultantId);
	}

	/**
	 * Returns all the consultant customers where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching consultant customers
	 */
	public static List<ConsultantCustomer> findBycustomerId(Long customerId) {
		return getPersistence().findBycustomerId(customerId);
	}

	/**
	 * Returns a range of all the consultant customers where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @return the range of matching consultant customers
	 */
	public static List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end) {

		return getPersistence().findBycustomerId(customerId, start, end);
	}

	/**
	 * Returns an ordered range of all the consultant customers where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching consultant customers
	 */
	public static List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().findBycustomerId(
			customerId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the consultant customers where customerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param customerId the customer ID
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching consultant customers
	 */
	public static List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBycustomerId(
			customerId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer findBycustomerId_First(
			Long customerId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findBycustomerId_First(
			customerId, orderByComparator);
	}

	/**
	 * Returns the first consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer fetchBycustomerId_First(
		Long customerId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().fetchBycustomerId_First(
			customerId, orderByComparator);
	}

	/**
	 * Returns the last consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer findBycustomerId_Last(
			Long customerId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findBycustomerId_Last(
			customerId, orderByComparator);
	}

	/**
	 * Returns the last consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public static ConsultantCustomer fetchBycustomerId_Last(
		Long customerId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().fetchBycustomerId_Last(
			customerId, orderByComparator);
	}

	/**
	 * Returns the consultant customers before and after the current consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param id the primary key of the current consultant customer
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public static ConsultantCustomer[] findBycustomerId_PrevAndNext(
			long id, Long customerId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findBycustomerId_PrevAndNext(
			id, customerId, orderByComparator);
	}

	/**
	 * Removes all the consultant customers where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	public static void removeBycustomerId(Long customerId) {
		getPersistence().removeBycustomerId(customerId);
	}

	/**
	 * Returns the number of consultant customers where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching consultant customers
	 */
	public static int countBycustomerId(Long customerId) {
		return getPersistence().countBycustomerId(customerId);
	}

	/**
	 * Caches the consultant customer in the entity cache if it is enabled.
	 *
	 * @param consultantCustomer the consultant customer
	 */
	public static void cacheResult(ConsultantCustomer consultantCustomer) {
		getPersistence().cacheResult(consultantCustomer);
	}

	/**
	 * Caches the consultant customers in the entity cache if it is enabled.
	 *
	 * @param consultantCustomers the consultant customers
	 */
	public static void cacheResult(
		List<ConsultantCustomer> consultantCustomers) {

		getPersistence().cacheResult(consultantCustomers);
	}

	/**
	 * Creates a new consultant customer with the primary key. Does not add the consultant customer to the database.
	 *
	 * @param id the primary key for the new consultant customer
	 * @return the new consultant customer
	 */
	public static ConsultantCustomer create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the consultant customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer that was removed
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public static ConsultantCustomer remove(long id)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().remove(id);
	}

	public static ConsultantCustomer updateImpl(
		ConsultantCustomer consultantCustomer) {

		return getPersistence().updateImpl(consultantCustomer);
	}

	/**
	 * Returns the consultant customer with the primary key or throws a <code>NoSuchConsultantCustomerException</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public static ConsultantCustomer findByPrimaryKey(long id)
		throws si.bintegra.sp.exception.NoSuchConsultantCustomerException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the consultant customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer, or <code>null</code> if a consultant customer with the primary key could not be found
	 */
	public static ConsultantCustomer fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the consultant customers.
	 *
	 * @return the consultant customers
	 */
	public static List<ConsultantCustomer> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the consultant customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @return the range of consultant customers
	 */
	public static List<ConsultantCustomer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the consultant customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consultant customers
	 */
	public static List<ConsultantCustomer> findAll(
		int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the consultant customers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantCustomerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultant customers
	 * @param end the upper bound of the range of consultant customers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of consultant customers
	 */
	public static List<ConsultantCustomer> findAll(
		int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the consultant customers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of consultant customers.
	 *
	 * @return the number of consultant customers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConsultantCustomerPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ConsultantCustomerPersistence _persistence;

}