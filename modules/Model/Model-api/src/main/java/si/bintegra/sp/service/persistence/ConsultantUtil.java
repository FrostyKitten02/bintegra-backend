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

import si.bintegra.sp.model.Consultant;

/**
 * The persistence utility for the consultant service. This utility wraps <code>si.bintegra.sp.service.persistence.impl.ConsultantPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantPersistence
 * @generated
 */
public class ConsultantUtil {

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
	public static void clearCache(Consultant consultant) {
		getPersistence().clearCache(consultant);
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
	public static Map<Serializable, Consultant> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Consultant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Consultant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Consultant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Consultant> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Consultant update(Consultant consultant) {
		return getPersistence().update(consultant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Consultant update(
		Consultant consultant, ServiceContext serviceContext) {

		return getPersistence().update(consultant, serviceContext);
	}

	/**
	 * Returns the consultant where userId = &#63; or throws a <code>NoSuchConsultantException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching consultant
	 * @throws NoSuchConsultantException if a matching consultant could not be found
	 */
	public static Consultant findByuserId(long userId)
		throws si.bintegra.sp.exception.NoSuchConsultantException {

		return getPersistence().findByuserId(userId);
	}

	/**
	 * Returns the consultant where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching consultant, or <code>null</code> if a matching consultant could not be found
	 */
	public static Consultant fetchByuserId(long userId) {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	 * Returns the consultant where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching consultant, or <code>null</code> if a matching consultant could not be found
	 */
	public static Consultant fetchByuserId(
		long userId, boolean useFinderCache) {

		return getPersistence().fetchByuserId(userId, useFinderCache);
	}

	/**
	 * Removes the consultant where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the consultant that was removed
	 */
	public static Consultant removeByuserId(long userId)
		throws si.bintegra.sp.exception.NoSuchConsultantException {

		return getPersistence().removeByuserId(userId);
	}

	/**
	 * Returns the number of consultants where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching consultants
	 */
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	 * Caches the consultant in the entity cache if it is enabled.
	 *
	 * @param consultant the consultant
	 */
	public static void cacheResult(Consultant consultant) {
		getPersistence().cacheResult(consultant);
	}

	/**
	 * Caches the consultants in the entity cache if it is enabled.
	 *
	 * @param consultants the consultants
	 */
	public static void cacheResult(List<Consultant> consultants) {
		getPersistence().cacheResult(consultants);
	}

	/**
	 * Creates a new consultant with the primary key. Does not add the consultant to the database.
	 *
	 * @param id the primary key for the new consultant
	 * @return the new consultant
	 */
	public static Consultant create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the consultant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant that was removed
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	public static Consultant remove(long id)
		throws si.bintegra.sp.exception.NoSuchConsultantException {

		return getPersistence().remove(id);
	}

	public static Consultant updateImpl(Consultant consultant) {
		return getPersistence().updateImpl(consultant);
	}

	/**
	 * Returns the consultant with the primary key or throws a <code>NoSuchConsultantException</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	public static Consultant findByPrimaryKey(long id)
		throws si.bintegra.sp.exception.NoSuchConsultantException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the consultant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant, or <code>null</code> if a consultant with the primary key could not be found
	 */
	public static Consultant fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the consultants.
	 *
	 * @return the consultants
	 */
	public static List<Consultant> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the consultants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultants
	 * @param end the upper bound of the range of consultants (not inclusive)
	 * @return the range of consultants
	 */
	public static List<Consultant> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the consultants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultants
	 * @param end the upper bound of the range of consultants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of consultants
	 */
	public static List<Consultant> findAll(
		int start, int end, OrderByComparator<Consultant> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the consultants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConsultantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of consultants
	 * @param end the upper bound of the range of consultants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of consultants
	 */
	public static List<Consultant> findAll(
		int start, int end, OrderByComparator<Consultant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the consultants from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of consultants.
	 *
	 * @return the number of consultants
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ConsultantPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ConsultantPersistence _persistence;

}