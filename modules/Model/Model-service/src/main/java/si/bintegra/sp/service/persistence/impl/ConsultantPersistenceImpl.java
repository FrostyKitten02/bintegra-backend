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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import si.bintegra.sp.exception.NoSuchConsultantException;
import si.bintegra.sp.model.Consultant;
import si.bintegra.sp.model.ConsultantTable;
import si.bintegra.sp.model.impl.ConsultantImpl;
import si.bintegra.sp.model.impl.ConsultantModelImpl;
import si.bintegra.sp.service.persistence.ConsultantPersistence;
import si.bintegra.sp.service.persistence.ConsultantUtil;
import si.bintegra.sp.service.persistence.impl.constants.SPPersistenceConstants;

/**
 * The persistence implementation for the consultant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConsultantPersistence.class)
public class ConsultantPersistenceImpl
	extends BasePersistenceImpl<Consultant> implements ConsultantPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConsultantUtil</code> to access the consultant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConsultantImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByuserId;
	private FinderPath _finderPathCountByuserId;

	/**
	 * Returns the consultant where userId = &#63; or throws a <code>NoSuchConsultantException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @return the matching consultant
	 * @throws NoSuchConsultantException if a matching consultant could not be found
	 */
	@Override
	public Consultant findByuserId(long userId)
		throws NoSuchConsultantException {

		Consultant consultant = fetchByuserId(userId);

		if (consultant == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("userId=");
			sb.append(userId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchConsultantException(sb.toString());
		}

		return consultant;
	}

	/**
	 * Returns the consultant where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @return the matching consultant, or <code>null</code> if a matching consultant could not be found
	 */
	@Override
	public Consultant fetchByuserId(long userId) {
		return fetchByuserId(userId, true);
	}

	/**
	 * Returns the consultant where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching consultant, or <code>null</code> if a matching consultant could not be found
	 */
	@Override
	public Consultant fetchByuserId(long userId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByuserId, finderArgs, this);
		}

		if (result instanceof Consultant) {
			Consultant consultant = (Consultant)result;

			if (userId != consultant.getUserId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CONSULTANT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				List<Consultant> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByuserId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {userId};
							}

							_log.warn(
								"ConsultantPersistenceImpl.fetchByuserId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Consultant consultant = list.get(0);

					result = consultant;

					cacheResult(consultant);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Consultant)result;
		}
	}

	/**
	 * Removes the consultant where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @return the consultant that was removed
	 */
	@Override
	public Consultant removeByuserId(long userId)
		throws NoSuchConsultantException {

		Consultant consultant = findByuserId(userId);

		return remove(consultant);
	}

	/**
	 * Returns the number of consultants where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching consultants
	 */
	@Override
	public int countByuserId(long userId) {
		FinderPath finderPath = _finderPathCountByuserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONSULTANT_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"consultant.userId = ?";

	public ConsultantPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Consultant.class);

		setModelImplClass(ConsultantImpl.class);
		setModelPKClass(long.class);

		setTable(ConsultantTable.INSTANCE);
	}

	/**
	 * Caches the consultant in the entity cache if it is enabled.
	 *
	 * @param consultant the consultant
	 */
	@Override
	public void cacheResult(Consultant consultant) {
		entityCache.putResult(
			ConsultantImpl.class, consultant.getPrimaryKey(), consultant);

		finderCache.putResult(
			_finderPathFetchByuserId, new Object[] {consultant.getUserId()},
			consultant);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the consultants in the entity cache if it is enabled.
	 *
	 * @param consultants the consultants
	 */
	@Override
	public void cacheResult(List<Consultant> consultants) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (consultants.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Consultant consultant : consultants) {
			if (entityCache.getResult(
					ConsultantImpl.class, consultant.getPrimaryKey()) == null) {

				cacheResult(consultant);
			}
		}
	}

	/**
	 * Clears the cache for all consultants.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConsultantImpl.class);

		finderCache.clearCache(ConsultantImpl.class);
	}

	/**
	 * Clears the cache for the consultant.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Consultant consultant) {
		entityCache.removeResult(ConsultantImpl.class, consultant);
	}

	@Override
	public void clearCache(List<Consultant> consultants) {
		for (Consultant consultant : consultants) {
			entityCache.removeResult(ConsultantImpl.class, consultant);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ConsultantImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ConsultantImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ConsultantModelImpl consultantModelImpl) {

		Object[] args = new Object[] {consultantModelImpl.getUserId()};

		finderCache.putResult(_finderPathCountByuserId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByuserId, args, consultantModelImpl);
	}

	/**
	 * Creates a new consultant with the primary key. Does not add the consultant to the database.
	 *
	 * @param id the primary key for the new consultant
	 * @return the new consultant
	 */
	@Override
	public Consultant create(long id) {
		Consultant consultant = new ConsultantImpl();

		consultant.setNew(true);
		consultant.setPrimaryKey(id);

		return consultant;
	}

	/**
	 * Removes the consultant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant that was removed
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	@Override
	public Consultant remove(long id) throws NoSuchConsultantException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the consultant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the consultant
	 * @return the consultant that was removed
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	@Override
	public Consultant remove(Serializable primaryKey)
		throws NoSuchConsultantException {

		Session session = null;

		try {
			session = openSession();

			Consultant consultant = (Consultant)session.get(
				ConsultantImpl.class, primaryKey);

			if (consultant == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConsultantException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(consultant);
		}
		catch (NoSuchConsultantException noSuchEntityException) {
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
	protected Consultant removeImpl(Consultant consultant) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(consultant)) {
				consultant = (Consultant)session.get(
					ConsultantImpl.class, consultant.getPrimaryKeyObj());
			}

			if (consultant != null) {
				session.delete(consultant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (consultant != null) {
			clearCache(consultant);
		}

		return consultant;
	}

	@Override
	public Consultant updateImpl(Consultant consultant) {
		boolean isNew = consultant.isNew();

		if (!(consultant instanceof ConsultantModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(consultant.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(consultant);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in consultant proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Consultant implementation " +
					consultant.getClass());
		}

		ConsultantModelImpl consultantModelImpl =
			(ConsultantModelImpl)consultant;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(consultant);
			}
			else {
				consultant = (Consultant)session.merge(consultant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ConsultantImpl.class, consultantModelImpl, false, true);

		cacheUniqueFindersCache(consultantModelImpl);

		if (isNew) {
			consultant.setNew(false);
		}

		consultant.resetOriginalValues();

		return consultant;
	}

	/**
	 * Returns the consultant with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the consultant
	 * @return the consultant
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	@Override
	public Consultant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConsultantException {

		Consultant consultant = fetchByPrimaryKey(primaryKey);

		if (consultant == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConsultantException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return consultant;
	}

	/**
	 * Returns the consultant with the primary key or throws a <code>NoSuchConsultantException</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant
	 * @throws NoSuchConsultantException if a consultant with the primary key could not be found
	 */
	@Override
	public Consultant findByPrimaryKey(long id)
		throws NoSuchConsultantException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the consultant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the consultant
	 * @return the consultant, or <code>null</code> if a consultant with the primary key could not be found
	 */
	@Override
	public Consultant fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the consultants.
	 *
	 * @return the consultants
	 */
	@Override
	public List<Consultant> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Consultant> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Consultant> findAll(
		int start, int end, OrderByComparator<Consultant> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Consultant> findAll(
		int start, int end, OrderByComparator<Consultant> orderByComparator,
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

		List<Consultant> list = null;

		if (useFinderCache) {
			list = (List<Consultant>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONSULTANT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONSULTANT;

				sql = sql.concat(ConsultantModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Consultant>)QueryUtil.list(
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
	 * Removes all the consultants from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Consultant consultant : findAll()) {
			remove(consultant);
		}
	}

	/**
	 * Returns the number of consultants.
	 *
	 * @return the number of consultants
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONSULTANT);

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
		return _SQL_SELECT_CONSULTANT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConsultantModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the consultant persistence.
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

		_finderPathFetchByuserId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByuserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		_setConsultantUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setConsultantUtilPersistence(null);

		entityCache.removeCache(ConsultantImpl.class.getName());
	}

	private void _setConsultantUtilPersistence(
		ConsultantPersistence consultantPersistence) {

		try {
			Field field = ConsultantUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, consultantPersistence);
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

	private static final String _SQL_SELECT_CONSULTANT =
		"SELECT consultant FROM Consultant consultant";

	private static final String _SQL_SELECT_CONSULTANT_WHERE =
		"SELECT consultant FROM Consultant consultant WHERE ";

	private static final String _SQL_COUNT_CONSULTANT =
		"SELECT COUNT(consultant) FROM Consultant consultant";

	private static final String _SQL_COUNT_CONSULTANT_WHERE =
		"SELECT COUNT(consultant) FROM Consultant consultant WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "consultant.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Consultant exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Consultant exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConsultantPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}