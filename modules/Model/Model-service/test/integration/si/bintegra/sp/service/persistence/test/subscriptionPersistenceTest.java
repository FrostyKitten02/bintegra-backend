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

import si.bintegra.sp.exception.NoSuchSubscriptionException;
import si.bintegra.sp.model.Subscription;
import si.bintegra.sp.service.SubscriptionLocalServiceUtil;
import si.bintegra.sp.service.persistence.SubscriptionPersistence;
import si.bintegra.sp.service.persistence.SubscriptionUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SubscriptionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "si.bintegra.sp.service"));

	@Before
	public void setUp() {
		_persistence = SubscriptionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Subscription> iterator = _subscriptions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subscription subscription = _persistence.create(pk);

		Assert.assertNotNull(subscription);

		Assert.assertEquals(subscription.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Subscription newSubscription = addSubscription();

		_persistence.remove(newSubscription);

		Subscription existingSubscription = _persistence.fetchByPrimaryKey(
			newSubscription.getPrimaryKey());

		Assert.assertNull(existingSubscription);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSubscription();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subscription newSubscription = _persistence.create(pk);

		newSubscription.setPackageOffer(RandomTestUtil.nextLong());

		newSubscription.setUserId(RandomTestUtil.nextLong());

		newSubscription.setPhoneId(RandomTestUtil.nextLong());

		_subscriptions.add(_persistence.update(newSubscription));

		Subscription existingSubscription = _persistence.findByPrimaryKey(
			newSubscription.getPrimaryKey());

		Assert.assertEquals(
			existingSubscription.getId(), newSubscription.getId());
		Assert.assertEquals(
			existingSubscription.getPackageOffer(),
			newSubscription.getPackageOffer());
		Assert.assertEquals(
			existingSubscription.getUserId(), newSubscription.getUserId());
		Assert.assertEquals(
			existingSubscription.getPhoneId(), newSubscription.getPhoneId());
	}

	@Test
	public void testCountBypackageOffer() throws Exception {
		_persistence.countBypackageOffer(RandomTestUtil.nextLong());

		_persistence.countBypackageOffer(0L);
	}

	@Test
	public void testCountByuserId() throws Exception {
		_persistence.countByuserId(RandomTestUtil.nextLong());

		_persistence.countByuserId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Subscription newSubscription = addSubscription();

		Subscription existingSubscription = _persistence.findByPrimaryKey(
			newSubscription.getPrimaryKey());

		Assert.assertEquals(existingSubscription, newSubscription);
	}

	@Test(expected = NoSuchSubscriptionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Subscription> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SP_Subscription", "id", true, "packageOffer", true, "userId", true,
			"phoneId", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Subscription newSubscription = addSubscription();

		Subscription existingSubscription = _persistence.fetchByPrimaryKey(
			newSubscription.getPrimaryKey());

		Assert.assertEquals(existingSubscription, newSubscription);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subscription missingSubscription = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSubscription);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Subscription newSubscription1 = addSubscription();
		Subscription newSubscription2 = addSubscription();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubscription1.getPrimaryKey());
		primaryKeys.add(newSubscription2.getPrimaryKey());

		Map<Serializable, Subscription> subscriptions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, subscriptions.size());
		Assert.assertEquals(
			newSubscription1,
			subscriptions.get(newSubscription1.getPrimaryKey()));
		Assert.assertEquals(
			newSubscription2,
			subscriptions.get(newSubscription2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Subscription> subscriptions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(subscriptions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Subscription newSubscription = addSubscription();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubscription.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Subscription> subscriptions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, subscriptions.size());
		Assert.assertEquals(
			newSubscription,
			subscriptions.get(newSubscription.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Subscription> subscriptions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(subscriptions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Subscription newSubscription = addSubscription();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSubscription.getPrimaryKey());

		Map<Serializable, Subscription> subscriptions =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, subscriptions.size());
		Assert.assertEquals(
			newSubscription,
			subscriptions.get(newSubscription.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SubscriptionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Subscription>() {

				@Override
				public void performAction(Subscription subscription) {
					Assert.assertNotNull(subscription);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Subscription newSubscription = addSubscription();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subscription.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newSubscription.getId()));

		List<Subscription> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Subscription existingSubscription = result.get(0);

		Assert.assertEquals(existingSubscription, newSubscription);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subscription.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Subscription> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Subscription newSubscription = addSubscription();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Subscription.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newSubscription.getId();

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
			Subscription.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Subscription addSubscription() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Subscription subscription = _persistence.create(pk);

		subscription.setPackageOffer(RandomTestUtil.nextLong());

		subscription.setUserId(RandomTestUtil.nextLong());

		subscription.setPhoneId(RandomTestUtil.nextLong());

		_subscriptions.add(_persistence.update(subscription));

		return subscription;
	}

	private List<Subscription> _subscriptions = new ArrayList<Subscription>();
	private SubscriptionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}