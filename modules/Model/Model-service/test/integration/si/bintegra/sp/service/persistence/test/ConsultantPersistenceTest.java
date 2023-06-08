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

package si.bintegra.sp.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import si.bintegra.sp.exception.NoSuchConsultantException;
import si.bintegra.sp.model.Consultant;
import si.bintegra.sp.service.ConsultantLocalServiceUtil;
import si.bintegra.sp.service.persistence.ConsultantPersistence;
import si.bintegra.sp.service.persistence.ConsultantUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ConsultantPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "si.bintegra.sp.service"));

	@Before
	public void setUp() {
		_persistence = ConsultantUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Consultant> iterator = _consultants.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Consultant consultant = _persistence.create(pk);

		Assert.assertNotNull(consultant);

		Assert.assertEquals(consultant.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Consultant newConsultant = addConsultant();

		_persistence.remove(newConsultant);

		Consultant existingConsultant = _persistence.fetchByPrimaryKey(
			newConsultant.getPrimaryKey());

		Assert.assertNull(existingConsultant);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addConsultant();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Consultant newConsultant = _persistence.create(pk);

		newConsultant.setUserId(RandomTestUtil.nextLong());

		_consultants.add(_persistence.update(newConsultant));

		Consultant existingConsultant = _persistence.findByPrimaryKey(
			newConsultant.getPrimaryKey());

		Assert.assertEquals(existingConsultant.getId(), newConsultant.getId());
		Assert.assertEquals(
			existingConsultant.getUserId(), newConsultant.getUserId());
	}

	@Test
	public void testCountByuserId() throws Exception {
		_persistence.countByuserId(RandomTestUtil.nextLong());

		_persistence.countByuserId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Consultant newConsultant = addConsultant();

		Consultant existingConsultant = _persistence.findByPrimaryKey(
			newConsultant.getPrimaryKey());

		Assert.assertEquals(existingConsultant, newConsultant);
	}

	@Test(expected = NoSuchConsultantException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Consultant> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SP_Consultant", "id", true, "userId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Consultant newConsultant = addConsultant();

		Consultant existingConsultant = _persistence.fetchByPrimaryKey(
			newConsultant.getPrimaryKey());

		Assert.assertEquals(existingConsultant, newConsultant);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Consultant missingConsultant = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingConsultant);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Consultant newConsultant1 = addConsultant();
		Consultant newConsultant2 = addConsultant();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConsultant1.getPrimaryKey());
		primaryKeys.add(newConsultant2.getPrimaryKey());

		Map<Serializable, Consultant> consultants =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, consultants.size());
		Assert.assertEquals(
			newConsultant1, consultants.get(newConsultant1.getPrimaryKey()));
		Assert.assertEquals(
			newConsultant2, consultants.get(newConsultant2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Consultant> consultants =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(consultants.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Consultant newConsultant = addConsultant();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConsultant.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Consultant> consultants =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, consultants.size());
		Assert.assertEquals(
			newConsultant, consultants.get(newConsultant.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Consultant> consultants =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(consultants.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Consultant newConsultant = addConsultant();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConsultant.getPrimaryKey());

		Map<Serializable, Consultant> consultants =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, consultants.size());
		Assert.assertEquals(
			newConsultant, consultants.get(newConsultant.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ConsultantLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Consultant>() {

				@Override
				public void performAction(Consultant consultant) {
					Assert.assertNotNull(consultant);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Consultant newConsultant = addConsultant();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Consultant.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newConsultant.getId()));

		List<Consultant> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Consultant existingConsultant = result.get(0);

		Assert.assertEquals(existingConsultant, newConsultant);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Consultant.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Consultant> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Consultant newConsultant = addConsultant();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Consultant.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newConsultant.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Consultant.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Consultant newConsultant = addConsultant();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newConsultant.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		Consultant newConsultant = addConsultant();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Consultant.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newConsultant.getId()));

		List<Consultant> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Consultant consultant) {
		Assert.assertEquals(
			Long.valueOf(consultant.getUserId()),
			ReflectionTestUtil.<Long>invoke(
				consultant, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "userId"));
	}

	protected Consultant addConsultant() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Consultant consultant = _persistence.create(pk);

		consultant.setUserId(RandomTestUtil.nextLong());

		_consultants.add(_persistence.update(consultant));

		return consultant;
	}

	private List<Consultant> _consultants = new ArrayList<Consultant>();
	private ConsultantPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}