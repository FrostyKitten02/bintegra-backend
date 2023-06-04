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

import si.bintegra.sp.exception.NoSuchConsultantException;
import si.bintegra.sp.model.Consultant;

/**
 * The persistence interface for the consultant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ConsultantUtil
 * @generated
 */
@ProviderType
public interface ConsultantPersistence extends BasePersistence<Consultant> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConsultantUtil} to access the consultant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the consultant in the entity cache if it is enabled.
	 *
	 * @param consultant the consultant
	 */
	public void cacheResult(Consultant consultant);

	/**
	 * Caches the consultants in the entity cache if it is enabled.
	 *
	 * @param consultants the consultants
	 */
	public void cacheResult(java.util.List<Consultant> consultants);

	/**
	 * Creates a new consultant with the primary key. Does not add the consultant to the database.
	 *
	 * @param id the primary key for the new consultant
	 * @return the new consultant
	 */
	public Consultant create(long id);

	/**
	 * Removes the consultant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant that was removed
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	public Consultant remove(long id) throws NoSuchConsultantException;

	public Consultant updateImpl(Consultant consultant);

	/**
	 * Returns the consultant with the primary key or throws a <code>NoSuchConsultantException</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	public Consultant findByPrimaryKey(long id)
		throws NoSuchConsultantException;

	/**
	 * Returns the consultant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant, or <code>null</code> if a consultant with the primary key could not be found
	 */
	public Consultant fetchByPrimaryKey(long id);

	/**
	 * Returns all the consultants.
	 *
	 * @return the consultants
	 */
	public java.util.List<Consultant> findAll();

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
	public java.util.List<Consultant> findAll(int start, int end);

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
	public java.util.List<Consultant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Consultant>
			orderByComparator);

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
	public java.util.List<Consultant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Consultant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the consultants from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of consultants.
	 *
	 * @return the number of consultants
	 */
	public int countAll();

}