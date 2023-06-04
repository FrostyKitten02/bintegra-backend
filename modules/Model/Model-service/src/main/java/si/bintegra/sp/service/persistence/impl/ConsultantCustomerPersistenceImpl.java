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

package si.bintegra.sp.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import si.bintegra.sp.exception.NoSuchConsultantCustomerException;
import si.bintegra.sp.model.ConsultantCustomer;
import si.bintegra.sp.model.ConsultantCustomerTable;
import si.bintegra.sp.model.impl.ConsultantCustomerImpl;
import si.bintegra.sp.model.impl.ConsultantCustomerModelImpl;
import si.bintegra.sp.service.persistence.ConsultantCustomerPersistence;
import si.bintegra.sp.service.persistence.ConsultantCustomerUtil;
import si.bintegra.sp.service.persistence.impl.constants.SPPersistenceConstants;

/**
 * The persistence implementation for the consultant customer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConsultantCustomerPersistence.class)
public class ConsultantCustomerPersistenceImpl
	extends BasePersistenceImpl<ConsultantCustomer>
	implements ConsultantCustomerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConsultantCustomerUtil</code> to access the consultant customer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConsultantCustomerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByconsultantId;
	private FinderPath _finderPathWithoutPaginationFindByconsultantId;
	private FinderPath _finderPathCountByconsultantId;

	/**
	 * Returns all the consultant customers where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @return the matching consultant customers
	 */
	@Override
	public List<ConsultantCustomer> findByconsultantId(Long consultantId) {
		return findByconsultantId(
			consultantId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end) {

		return findByconsultantId(consultantId, start, end, null);
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
	@Override
	public List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return findByconsultantId(
			consultantId, start, end, orderByComparator, true);
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
	@Override
	public List<ConsultantCustomer> findByconsultantId(
		Long consultantId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByconsultantId;
				finderArgs = new Object[] {consultantId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByconsultantId;
			finderArgs = new Object[] {
				consultantId, start, end, orderByComparator
			};
		}

		List<ConsultantCustomer> list = null;

		if (useFinderCache) {
			list = (List<ConsultantCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsultantCustomer consultantCustomer : list) {
					if (!Objects.equals(
							consultantId,
							consultantCustomer.getConsultantId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONSULTANTCUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_CONSULTANTID_CONSULTANTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsultantCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(consultantId.longValue());

				list = (List<ConsultantCustomer>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer findByconsultantId_First(
			Long consultantId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = fetchByconsultantId_First(
			consultantId, orderByComparator);

		if (consultantCustomer != null) {
			return consultantCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consultantId=");
		sb.append(consultantId);

		sb.append("}");

		throw new NoSuchConsultantCustomerException(sb.toString());
	}

	/**
	 * Returns the first consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer fetchByconsultantId_First(
		Long consultantId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		List<ConsultantCustomer> list = findByconsultantId(
			consultantId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer findByconsultantId_Last(
			Long consultantId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = fetchByconsultantId_Last(
			consultantId, orderByComparator);

		if (consultantCustomer != null) {
			return consultantCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("consultantId=");
		sb.append(consultantId);

		sb.append("}");

		throw new NoSuchConsultantCustomerException(sb.toString());
	}

	/**
	 * Returns the last consultant customer in the ordered set where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer fetchByconsultantId_Last(
		Long consultantId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		int count = countByconsultantId(consultantId);

		if (count == 0) {
			return null;
		}

		List<ConsultantCustomer> list = findByconsultantId(
			consultantId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ConsultantCustomer[] findByconsultantId_PrevAndNext(
			long id, Long consultantId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConsultantCustomer[] array = new ConsultantCustomerImpl[3];

			array[0] = getByconsultantId_PrevAndNext(
				session, consultantCustomer, consultantId, orderByComparator,
				true);

			array[1] = consultantCustomer;

			array[2] = getByconsultantId_PrevAndNext(
				session, consultantCustomer, consultantId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsultantCustomer getByconsultantId_PrevAndNext(
		Session session, ConsultantCustomer consultantCustomer,
		Long consultantId,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONSULTANTCUSTOMER_WHERE);

		sb.append(_FINDER_COLUMN_CONSULTANTID_CONSULTANTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsultantCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(consultantId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consultantCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsultantCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consultant customers where consultantId = &#63; from the database.
	 *
	 * @param consultantId the consultant ID
	 */
	@Override
	public void removeByconsultantId(Long consultantId) {
		for (ConsultantCustomer consultantCustomer :
				findByconsultantId(
					consultantId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(consultantCustomer);
		}
	}

	/**
	 * Returns the number of consultant customers where consultantId = &#63;.
	 *
	 * @param consultantId the consultant ID
	 * @return the number of matching consultant customers
	 */
	@Override
	public int countByconsultantId(Long consultantId) {
		FinderPath finderPath = _finderPathCountByconsultantId;

		Object[] finderArgs = new Object[] {consultantId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSULTANTCUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_CONSULTANTID_CONSULTANTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(consultantId.longValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CONSULTANTID_CONSULTANTID_2 =
		"consultantCustomer.consultantId = ?";

	private FinderPath _finderPathWithPaginationFindBycustomerId;
	private FinderPath _finderPathWithoutPaginationFindBycustomerId;
	private FinderPath _finderPathCountBycustomerId;

	/**
	 * Returns all the consultant customers where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the matching consultant customers
	 */
	@Override
	public List<ConsultantCustomer> findBycustomerId(Long customerId) {
		return findBycustomerId(
			customerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end) {

		return findBycustomerId(customerId, start, end, null);
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
	@Override
	public List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return findBycustomerId(
			customerId, start, end, orderByComparator, true);
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
	@Override
	public List<ConsultantCustomer> findBycustomerId(
		Long customerId, int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBycustomerId;
				finderArgs = new Object[] {customerId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBycustomerId;
			finderArgs = new Object[] {
				customerId, start, end, orderByComparator
			};
		}

		List<ConsultantCustomer> list = null;

		if (useFinderCache) {
			list = (List<ConsultantCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConsultantCustomer consultantCustomer : list) {
					if (!Objects.equals(
							customerId, consultantCustomer.getCustomerId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CONSULTANTCUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConsultantCustomerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId.longValue());

				list = (List<ConsultantCustomer>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer findBycustomerId_First(
			Long customerId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = fetchBycustomerId_First(
			customerId, orderByComparator);

		if (consultantCustomer != null) {
			return consultantCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append("}");

		throw new NoSuchConsultantCustomerException(sb.toString());
	}

	/**
	 * Returns the first consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer fetchBycustomerId_First(
		Long customerId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		List<ConsultantCustomer> list = findBycustomerId(
			customerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer
	 * @throws NoSuchConsultantCustomerException if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer findBycustomerId_Last(
			Long customerId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = fetchBycustomerId_Last(
			customerId, orderByComparator);

		if (consultantCustomer != null) {
			return consultantCustomer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("customerId=");
		sb.append(customerId);

		sb.append("}");

		throw new NoSuchConsultantCustomerException(sb.toString());
	}

	/**
	 * Returns the last consultant customer in the ordered set where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching consultant customer, or <code>null</code> if a matching consultant customer could not be found
	 */
	@Override
	public ConsultantCustomer fetchBycustomerId_Last(
		Long customerId,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		int count = countBycustomerId(customerId);

		if (count == 0) {
			return null;
		}

		List<ConsultantCustomer> list = findBycustomerId(
			customerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ConsultantCustomer[] findBycustomerId_PrevAndNext(
			long id, Long customerId,
			OrderByComparator<ConsultantCustomer> orderByComparator)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ConsultantCustomer[] array = new ConsultantCustomerImpl[3];

			array[0] = getBycustomerId_PrevAndNext(
				session, consultantCustomer, customerId, orderByComparator,
				true);

			array[1] = consultantCustomer;

			array[2] = getBycustomerId_PrevAndNext(
				session, consultantCustomer, customerId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConsultantCustomer getBycustomerId_PrevAndNext(
		Session session, ConsultantCustomer consultantCustomer, Long customerId,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONSULTANTCUSTOMER_WHERE);

		sb.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ConsultantCustomerModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(customerId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						consultantCustomer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConsultantCustomer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the consultant customers where customerId = &#63; from the database.
	 *
	 * @param customerId the customer ID
	 */
	@Override
	public void removeBycustomerId(Long customerId) {
		for (ConsultantCustomer consultantCustomer :
				findBycustomerId(
					customerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(consultantCustomer);
		}
	}

	/**
	 * Returns the number of consultant customers where customerId = &#63;.
	 *
	 * @param customerId the customer ID
	 * @return the number of matching consultant customers
	 */
	@Override
	public int countBycustomerId(Long customerId) {
		FinderPath finderPath = _finderPathCountBycustomerId;

		Object[] finderArgs = new Object[] {customerId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSULTANTCUSTOMER_WHERE);

			sb.append(_FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(customerId.longValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CUSTOMERID_CUSTOMERID_2 =
		"consultantCustomer.customerId = ?";

	public ConsultantCustomerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ConsultantCustomer.class);

		setModelImplClass(ConsultantCustomerImpl.class);
		setModelPKClass(long.class);

		setTable(ConsultantCustomerTable.INSTANCE);
	}

	/**
	 * Caches the consultant customer in the entity cache if it is enabled.
	 *
	 * @param consultantCustomer the consultant customer
	 */
	@Override
	public void cacheResult(ConsultantCustomer consultantCustomer) {
		entityCache.putResult(
			ConsultantCustomerImpl.class, consultantCustomer.getPrimaryKey(),
			consultantCustomer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the consultant customers in the entity cache if it is enabled.
	 *
	 * @param consultantCustomers the consultant customers
	 */
	@Override
	public void cacheResult(List<ConsultantCustomer> consultantCustomers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (consultantCustomers.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ConsultantCustomer consultantCustomer : consultantCustomers) {
			if (entityCache.getResult(
					ConsultantCustomerImpl.class,
					consultantCustomer.getPrimaryKey()) == null) {

				cacheResult(consultantCustomer);
			}
		}
	}

	/**
	 * Clears the cache for all consultant customers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConsultantCustomerImpl.class);

		finderCache.clearCache(ConsultantCustomerImpl.class);
	}

	/**
	 * Clears the cache for the consultant customer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConsultantCustomer consultantCustomer) {
		entityCache.removeResult(
			ConsultantCustomerImpl.class, consultantCustomer);
	}

	@Override
	public void clearCache(List<ConsultantCustomer> consultantCustomers) {
		for (ConsultantCustomer consultantCustomer : consultantCustomers) {
			entityCache.removeResult(
				ConsultantCustomerImpl.class, consultantCustomer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ConsultantCustomerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ConsultantCustomerImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new consultant customer with the primary key. Does not add the consultant customer to the database.
	 *
	 * @param id the primary key for the new consultant customer
	 * @return the new consultant customer
	 */
	@Override
	public ConsultantCustomer create(long id) {
		ConsultantCustomer consultantCustomer = new ConsultantCustomerImpl();

		consultantCustomer.setNew(true);
		consultantCustomer.setPrimaryKey(id);

		return consultantCustomer;
	}

	/**
	 * Removes the consultant customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer that was removed
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	@Override
	public ConsultantCustomer remove(long id)
		throws NoSuchConsultantCustomerException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the consultant customer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consultant customer
	 * @return the consultant customer that was removed
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	@Override
	public ConsultantCustomer remove(Serializable primaryKey)
		throws NoSuchConsultantCustomerException {

		Session session = null;

		try {
			session = openSession();

			ConsultantCustomer consultantCustomer =
				(ConsultantCustomer)session.get(
					ConsultantCustomerImpl.class, primaryKey);

			if (consultantCustomer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsultantCustomerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(consultantCustomer);
		}
		catch (NoSuchConsultantCustomerException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ConsultantCustomer removeImpl(
		ConsultantCustomer consultantCustomer) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consultantCustomer)) {
				consultantCustomer = (ConsultantCustomer)session.get(
					ConsultantCustomerImpl.class,
					consultantCustomer.getPrimaryKeyObj());
			}

			if (consultantCustomer != null) {
				session.delete(consultantCustomer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (consultantCustomer != null) {
			clearCache(consultantCustomer);
		}

		return consultantCustomer;
	}

	@Override
	public ConsultantCustomer updateImpl(
		ConsultantCustomer consultantCustomer) {

		boolean isNew = consultantCustomer.isNew();

		if (!(consultantCustomer instanceof ConsultantCustomerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(consultantCustomer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					consultantCustomer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in consultantCustomer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConsultantCustomer implementation " +
					consultantCustomer.getClass());
		}

		ConsultantCustomerModelImpl consultantCustomerModelImpl =
			(ConsultantCustomerModelImpl)consultantCustomer;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(consultantCustomer);
			}
			else {
				consultantCustomer = (ConsultantCustomer)session.merge(
					consultantCustomer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ConsultantCustomerImpl.class, consultantCustomerModelImpl, false,
			true);

		if (isNew) {
			consultantCustomer.setNew(false);
		}

		consultantCustomer.resetOriginalValues();

		return consultantCustomer;
	}

	/**
	 * Returns the consultant customer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consultant customer
	 * @return the consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	@Override
	public ConsultantCustomer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsultantCustomerException {

		ConsultantCustomer consultantCustomer = fetchByPrimaryKey(primaryKey);

		if (consultantCustomer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsultantCustomerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return consultantCustomer;
	}

	/**
	 * Returns the consultant customer with the primary key or throws a <code>NoSuchConsultantCustomerException</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer
	 * @throws NoSuchConsultantCustomerException if a consultant customer with the primary key could not be found
	 */
	@Override
	public ConsultantCustomer findByPrimaryKey(long id)
		throws NoSuchConsultantCustomerException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the consultant customer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant customer
	 * @return the consultant customer, or <code>null</code> if a consultant customer with the primary key could not be found
	 */
	@Override
	public ConsultantCustomer fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the consultant customers.
	 *
	 * @return the consultant customers
	 */
	@Override
	public List<ConsultantCustomer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ConsultantCustomer> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ConsultantCustomer> findAll(
		int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ConsultantCustomer> findAll(
		int start, int end,
		OrderByComparator<ConsultantCustomer> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ConsultantCustomer> list = null;

		if (useFinderCache) {
			list = (List<ConsultantCustomer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONSULTANTCUSTOMER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONSULTANTCUSTOMER;

				sql = sql.concat(ConsultantCustomerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ConsultantCustomer>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the consultant customers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConsultantCustomer consultantCustomer : findAll()) {
			remove(consultantCustomer);
		}
	}

	/**
	 * Returns the number of consultant customers.
	 *
	 * @return the number of consultant customers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_CONSULTANTCUSTOMER);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONSULTANTCUSTOMER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConsultantCustomerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the consultant customer persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByconsultantId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByconsultantId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"consultantId"}, true);

		_finderPathWithoutPaginationFindByconsultantId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByconsultantId",
			new String[] {Long.class.getName()}, new String[] {"consultantId"},
			true);

		_finderPathCountByconsultantId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByconsultantId",
			new String[] {Long.class.getName()}, new String[] {"consultantId"},
			false);

		_finderPathWithPaginationFindBycustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycustomerId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"customerId"}, true);

		_finderPathWithoutPaginationFindBycustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycustomerId",
			new String[] {Long.class.getName()}, new String[] {"customerId"},
			true);

		_finderPathCountBycustomerId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycustomerId",
			new String[] {Long.class.getName()}, new String[] {"customerId"},
			false);

		_setConsultantCustomerUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setConsultantCustomerUtilPersistence(null);

		entityCache.removeCache(ConsultantCustomerImpl.class.getName());
	}

	private void _setConsultantCustomerUtilPersistence(
		ConsultantCustomerPersistence consultantCustomerPersistence) {

		try {
			Field field = ConsultantCustomerUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, consultantCustomerPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = SPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = SPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONSULTANTCUSTOMER =
		"SELECT consultantCustomer FROM ConsultantCustomer consultantCustomer";

	private static final String _SQL_SELECT_CONSULTANTCUSTOMER_WHERE =
		"SELECT consultantCustomer FROM ConsultantCustomer consultantCustomer WHERE ";

	private static final String _SQL_COUNT_CONSULTANTCUSTOMER =
		"SELECT COUNT(consultantCustomer) FROM ConsultantCustomer consultantCustomer";

	private static final String _SQL_COUNT_CONSULTANTCUSTOMER_WHERE =
		"SELECT COUNT(consultantCustomer) FROM ConsultantCustomer consultantCustomer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "consultantCustomer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConsultantCustomer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConsultantCustomer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConsultantCustomerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}