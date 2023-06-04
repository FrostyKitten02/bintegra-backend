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

import si.bintegra.sp.exception.NoSuchConsultantCustomerException;
import si.bintegra.sp.model.ConsultantCustomer;
import si.bintegra.sp.service.ConsultantCustomerLocalServiceUtil;
import si.bintegra.sp.service.persistence.ConsultantCustomerPersistence;
import si.bintegra.sp.service.persistence.ConsultantCustomerUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ConsultantCustomerPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "si.bintegra.sp.service"));

	@Before
	public void setUp() {
		_persistence = ConsultantCustomerUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ConsultantCustomer> iterator = _consultantCustomers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConsultantCustomer consultantCustomer = _persistence.create(pk);

		Assert.assertNotNull(consultantCustomer);

		Assert.assertEquals(consultantCustomer.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		_persistence.remove(newConsultantCustomer);

		ConsultantCustomer existingConsultantCustomer =
			_persistence.fetchByPrimaryKey(
				newConsultantCustomer.getPrimaryKey());

		Assert.assertNull(existingConsultantCustomer);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addConsultantCustomer();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConsultantCustomer newConsultantCustomer = _persistence.create(pk);

		newConsultantCustomer.setConsultantId();

		newConsultantCustomer.setCustomerId();

		_consultantCustomers.add(_persistence.update(newConsultantCustomer));

		ConsultantCustomer existingConsultantCustomer =
			_persistence.findByPrimaryKey(
				newConsultantCustomer.getPrimaryKey());

		Assert.assertEquals(
			existingConsultantCustomer.getId(), newConsultantCustomer.getId());
		Assert.assertEquals(
			existingConsultantCustomer.getConsultantId(),
			newConsultantCustomer.getConsultantId());
		Assert.assertEquals(
			existingConsultantCustomer.getCustomerId(),
			newConsultantCustomer.getCustomerId());
	}

	@Test
	public void testCountByconsultantId() throws Exception {
		_persistence.countByconsultantId((Long)null);

		_persistence.countByconsultantId((Long)null);
	}

	@Test
	public void testCountBycustomerId() throws Exception {
		_persistence.countBycustomerId((Long)null);

		_persistence.countBycustomerId((Long)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		ConsultantCustomer existingConsultantCustomer =
			_persistence.findByPrimaryKey(
				newConsultantCustomer.getPrimaryKey());

		Assert.assertEquals(existingConsultantCustomer, newConsultantCustomer);
	}

	@Test(expected = NoSuchConsultantCustomerException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ConsultantCustomer> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SP_ConsultantCustomer", "id", true, "consultantId", true,
			"customerId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		ConsultantCustomer existingConsultantCustomer =
			_persistence.fetchByPrimaryKey(
				newConsultantCustomer.getPrimaryKey());

		Assert.assertEquals(existingConsultantCustomer, newConsultantCustomer);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConsultantCustomer missingConsultantCustomer =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingConsultantCustomer);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ConsultantCustomer newConsultantCustomer1 = addConsultantCustomer();
		ConsultantCustomer newConsultantCustomer2 = addConsultantCustomer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConsultantCustomer1.getPrimaryKey());
		primaryKeys.add(newConsultantCustomer2.getPrimaryKey());

		Map<Serializable, ConsultantCustomer> consultantCustomers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, consultantCustomers.size());
		Assert.assertEquals(
			newConsultantCustomer1,
			consultantCustomers.get(newConsultantCustomer1.getPrimaryKey()));
		Assert.assertEquals(
			newConsultantCustomer2,
			consultantCustomers.get(newConsultantCustomer2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ConsultantCustomer> consultantCustomers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(consultantCustomers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConsultantCustomer.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ConsultantCustomer> consultantCustomers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, consultantCustomers.size());
		Assert.assertEquals(
			newConsultantCustomer,
			consultantCustomers.get(newConsultantCustomer.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ConsultantCustomer> consultantCustomers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(consultantCustomers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newConsultantCustomer.getPrimaryKey());

		Map<Serializable, ConsultantCustomer> consultantCustomers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, consultantCustomers.size());
		Assert.assertEquals(
			newConsultantCustomer,
			consultantCustomers.get(newConsultantCustomer.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ConsultantCustomerLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ConsultantCustomer>() {

				@Override
				public void performAction(
					ConsultantCustomer consultantCustomer) {

					Assert.assertNotNull(consultantCustomer);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConsultantCustomer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newConsultantCustomer.getId()));

		List<ConsultantCustomer> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ConsultantCustomer existingConsultantCustomer = result.get(0);

		Assert.assertEquals(existingConsultantCustomer, newConsultantCustomer);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConsultantCustomer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<ConsultantCustomer> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ConsultantCustomer newConsultantCustomer = addConsultantCustomer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ConsultantCustomer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newConsultantCustomer.getId();

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
			ConsultantCustomer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ConsultantCustomer addConsultantCustomer() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ConsultantCustomer consultantCustomer = _persistence.create(pk);

		consultantCustomer.setConsultantId();

		consultantCustomer.setCustomerId();

		_consultantCustomers.add(_persistence.update(consultantCustomer));

		return consultantCustomer;
	}

	private List<ConsultantCustomer> _consultantCustomers =
		new ArrayList<ConsultantCustomer>();
	private ConsultantCustomerPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}