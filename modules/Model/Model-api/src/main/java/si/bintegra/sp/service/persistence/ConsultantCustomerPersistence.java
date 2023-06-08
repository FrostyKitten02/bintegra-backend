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

import si.bintegra.sp.exception.NoSuchConsultantCustomerException;
import si.bintegra.sp.model.ConsultantCustomer;

/**
 * The persistence interface for the consultant customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantCustomerUtil
 * @generated
 */
@ProviderType
public interface ConsultantCustomerPersistence
	extends BasePersistence<ConsultantCustomer> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConsultantCustomerUtil} to access the consultant customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the consultant customers where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @return the matching consultant customers
	 */
	public java.util.List<ConsultantCustomer> findByconsultantId(
		Long consultantId);

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
	public java.util.List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end);

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
	public java.util.List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

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
	public java.util.List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public ConsultantCustomer findByconsultantId_First(
			Long consultantId,
			com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
				orderByComparator)
		throws NoSuchConsultantCustomerException;

	/**
	 * Returns the first consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public ConsultantCustomer fetchByconsultantId_First(
		Long consultantId,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

	/**
	 * Returns the last consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public ConsultantCustomer findByconsultantId_Last(
			Long consultantId,
			com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
				orderByComparator)
		throws NoSuchConsultantCustomerException;

	/**
	 * Returns the last consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public ConsultantCustomer fetchByconsultantId_Last(
		Long consultantId,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

	/**
	 * Returns the consultant customers before and after the current consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param id the primary key of the current consultant customer
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public ConsultantCustomer[] findByconsultantId_PrevAndNext(
			long id, Long consultantId,
			com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
				orderByComparator)
		throws NoSuchConsultantCustomerException;

	/**
	 * Removes all the consultant customers where consultantId = &#63; from the database.
	 *
	 * @param consultantId the consultant ID
	 */
	public void removeByconsultantId(Long consultantId);

	/**
	 * Returns the number of consultant customers where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @return the number of matching consultant customers
	 */
	public int countByconsultantId(Long consultantId);

	/**
	 * Returns all the consultant customers where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching consultant customers
	 */
	public java.util.List<ConsultantCustomer> findBycustomerId(Long customerId);

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
	public java.util.List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end);

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
	public java.util.List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

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
	public java.util.List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public ConsultantCustomer findBycustomerId_First(
			Long customerId,
			com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
				orderByComparator)
		throws NoSuchConsultantCustomerException;

	/**
	 * Returns the first consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public ConsultantCustomer fetchBycustomerId_First(
		Long customerId,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

	/**
	 * Returns the last consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	public ConsultantCustomer findBycustomerId_Last(
			Long customerId,
			com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
				orderByComparator)
		throws NoSuchConsultantCustomerException;

	/**
	 * Returns the last consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	public ConsultantCustomer fetchBycustomerId_Last(
		Long customerId,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

	/**
	 * Returns the consultant customers before and after the current consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param id the primary key of the current consultant customer
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public ConsultantCustomer[] findBycustomerId_PrevAndNext(
			long id, Long customerId,
			com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
				orderByComparator)
		throws NoSuchConsultantCustomerException;

	/**
	 * Removes all the consultant customers where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	public void removeBycustomerId(Long customerId);

	/**
	 * Returns the number of consultant customers where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching consultant customers
	 */
	public int countBycustomerId(Long customerId);

	/**
	 * Caches the consultant customer in the entity cache if it is enabled.
	 *
	 * @param consultantCustomer the consultant customer
	 */
	public void cacheResult(ConsultantCustomer consultantCustomer);

	/**
	 * Caches the consultant customers in the entity cache if it is enabled.
	 *
	 * @param consultantCustomers the consultant customers
	 */
	public void cacheResult(
		java.util.List<ConsultantCustomer> consultantCustomers);

	/**
	 * Creates a new consultant customer with the primary key. Does not add the consultant customer to the database.
	 *
	 * @param id the primary key for the new consultant customer
	 * @return the new consultant customer
	 */
	public ConsultantCustomer create(long id);

	/**
	 * Removes the consultant customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer that was removed
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public ConsultantCustomer remove(long id)
		throws NoSuchConsultantCustomerException;

	public ConsultantCustomer updateImpl(ConsultantCustomer consultantCustomer);

	/**
	 * Returns the consultant customer with the primary key or throws a <code>NoSuchConsultantCustomerException</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	public ConsultantCustomer findByPrimaryKey(long id)
		throws NoSuchConsultantCustomerException;

	/**
	 * Returns the consultant customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer, or <code>null</code> if a consultant customer with the primary key could not be found
	 */
	public ConsultantCustomer fetchByPrimaryKey(long id);

	/**
	 * Returns all the consultant customers.
	 *
	 * @return the consultant customers
	 */
	public java.util.List<ConsultantCustomer> findAll();

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
	public java.util.List<ConsultantCustomer> findAll(int start, int end);

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
	public java.util.List<ConsultantCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator);

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
	public java.util.List<ConsultantCustomer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ConsultantCustomer>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the consultant customers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of consultant customers.
	 *
	 * @return the number of consultant customers
	 */
	public int countAll();

}