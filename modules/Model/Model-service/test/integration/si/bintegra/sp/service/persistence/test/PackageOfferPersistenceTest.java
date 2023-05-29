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

import si.bintegra.sp.exception.NoSuchPackageOfferException;
import si.bintegra.sp.model.PackageOffer;
import si.bintegra.sp.service.PackageOfferLocalServiceUtil;
import si.bintegra.sp.service.persistence.PackageOfferPersistence;
import si.bintegra.sp.service.persistence.PackageOfferUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class PackageOfferPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "si.bintegra.sp.service"));

	@Before
	public void setUp() {
		_persistence = PackageOfferUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<PackageOffer> iterator = _packageOffers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PackageOffer packageOffer = _persistence.create(pk);

		Assert.assertNotNull(packageOffer);

		Assert.assertEquals(packageOffer.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		_persistence.remove(newPackageOffer);

		PackageOffer existingPackageOffer = _persistence.fetchByPrimaryKey(
			newPackageOffer.getPrimaryKey());

		Assert.assertNull(existingPackageOffer);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPackageOffer();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PackageOffer newPackageOffer = _persistence.create(pk);

		newPackageOffer.setOfferId();

		newPackageOffer.setFullDuration();

		newPackageOffer.setDiscountDuration();

		newPackageOffer.setBasePrice();

		newPackageOffer.setDiscountPrice();

		newPackageOffer.setActive();

		_packageOffers.add(_persistence.update(newPackageOffer));

		PackageOffer existingPackageOffer = _persistence.findByPrimaryKey(
			newPackageOffer.getPrimaryKey());

		Assert.assertEquals(
			existingPackageOffer.getId(), newPackageOffer.getId());
		Assert.assertEquals(
			existingPackageOffer.getOfferId(), newPackageOffer.getOfferId());
		Assert.assertEquals(
			existingPackageOffer.getFullDuration(),
			newPackageOffer.getFullDuration());
		Assert.assertEquals(
			existingPackageOffer.getDiscountDuration(),
			newPackageOffer.getDiscountDuration());
		Assert.assertEquals(
			existingPackageOffer.getBasePrice(),
			newPackageOffer.getBasePrice());
		Assert.assertEquals(
			existingPackageOffer.getDiscountPrice(),
			newPackageOffer.getDiscountPrice());
		Assert.assertEquals(
			existingPackageOffer.getActive(), newPackageOffer.getActive());
	}

	@Test
	public void testCountByid() throws Exception {
		_persistence.countByid(RandomTestUtil.nextLong());

		_persistence.countByid(0L);
	}

	@Test
	public void testCountByactive() throws Exception {
		_persistence.countByactive((Boolean)null);

		_persistence.countByactive((Boolean)null);
	}

	@Test
	public void testCountByofferId() throws Exception {
		_persistence.countByofferId((Long)null);

		_persistence.countByofferId((Long)null);
	}

	@Test
	public void testCountByofferIdAndActive() throws Exception {
		_persistence.countByofferIdAndActive((Long)null, (Boolean)null);

		_persistence.countByofferIdAndActive((Long)null, (Boolean)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		PackageOffer existingPackageOffer = _persistence.findByPrimaryKey(
			newPackageOffer.getPrimaryKey());

		Assert.assertEquals(existingPackageOffer, newPackageOffer);
	}

	@Test(expected = NoSuchPackageOfferException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<PackageOffer> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SP_PackageOffer", "id", true, "offerId", true, "fullDuration",
			true, "discountDuration", true, "basePrice", true, "discountPrice",
			true, "active", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		PackageOffer existingPackageOffer = _persistence.fetchByPrimaryKey(
			newPackageOffer.getPrimaryKey());

		Assert.assertEquals(existingPackageOffer, newPackageOffer);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PackageOffer missingPackageOffer = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPackageOffer);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		PackageOffer newPackageOffer1 = addPackageOffer();
		PackageOffer newPackageOffer2 = addPackageOffer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPackageOffer1.getPrimaryKey());
		primaryKeys.add(newPackageOffer2.getPrimaryKey());

		Map<Serializable, PackageOffer> packageOffers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, packageOffers.size());
		Assert.assertEquals(
			newPackageOffer1,
			packageOffers.get(newPackageOffer1.getPrimaryKey()));
		Assert.assertEquals(
			newPackageOffer2,
			packageOffers.get(newPackageOffer2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, PackageOffer> packageOffers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(packageOffers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		PackageOffer newPackageOffer = addPackageOffer();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPackageOffer.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, PackageOffer> packageOffers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, packageOffers.size());
		Assert.assertEquals(
			newPackageOffer,
			packageOffers.get(newPackageOffer.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, PackageOffer> packageOffers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(packageOffers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPackageOffer.getPrimaryKey());

		Map<Serializable, PackageOffer> packageOffers =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, packageOffers.size());
		Assert.assertEquals(
			newPackageOffer,
			packageOffers.get(newPackageOffer.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PackageOfferLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<PackageOffer>() {

				@Override
				public void performAction(PackageOffer packageOffer) {
					Assert.assertNotNull(packageOffer);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PackageOffer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newPackageOffer.getId()));

		List<PackageOffer> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		PackageOffer existingPackageOffer = result.get(0);

		Assert.assertEquals(existingPackageOffer, newPackageOffer);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PackageOffer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<PackageOffer> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PackageOffer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newPackageOffer.getId();

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
			PackageOffer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		PackageOffer newPackageOffer = addPackageOffer();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newPackageOffer.getPrimaryKey()));
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

		PackageOffer newPackageOffer = addPackageOffer();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			PackageOffer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newPackageOffer.getId()));

		List<PackageOffer> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(PackageOffer packageOffer) {
		Assert.assertEquals(
			Long.valueOf(packageOffer.getId()),
			ReflectionTestUtil.<Long>invoke(
				packageOffer, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "id_"));
	}

	protected PackageOffer addPackageOffer() throws Exception {
		long pk = RandomTestUtil.nextLong();

		PackageOffer packageOffer = _persistence.create(pk);

		packageOffer.setOfferId();

		packageOffer.setFullDuration();

		packageOffer.setDiscountDuration();

		packageOffer.setBasePrice();

		packageOffer.setDiscountPrice();

		packageOffer.setActive();

		_packageOffers.add(_persistence.update(packageOffer));

		return packageOffer;
	}

	private List<PackageOffer> _packageOffers = new ArrayList<PackageOffer>();
	private PackageOfferPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}