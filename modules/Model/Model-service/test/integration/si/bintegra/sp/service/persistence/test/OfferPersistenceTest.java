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

import si.bintegra.sp.exception.NoSuchOfferException;
import si.bintegra.sp.model.Offer;
import si.bintegra.sp.service.OfferLocalServiceUtil;
import si.bintegra.sp.service.persistence.OfferPersistence;
import si.bintegra.sp.service.persistence.OfferUtil;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class OfferPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "si.bintegra.sp.service"));

	@Before
	public void setUp() {
		_persistence = OfferUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Offer> iterator = _offers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Offer offer = _persistence.create(pk);

		Assert.assertNotNull(offer);

		Assert.assertEquals(offer.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Offer newOffer = addOffer();

		_persistence.remove(newOffer);

		Offer existingOffer = _persistence.fetchByPrimaryKey(
			newOffer.getPrimaryKey());

		Assert.assertNull(existingOffer);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOffer();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Offer newOffer = _persistence.create(pk);

		newOffer.setType(RandomTestUtil.randomString());

		newOffer.setTitle(RandomTestUtil.randomString());

		newOffer.setDescription(RandomTestUtil.randomString());

		newOffer.setMobileData();

		newOffer.setMobileMinutes();

		newOffer.setMobileSms();

		newOffer.setProgramsNumber();

		newOffer.setDefaultNumberOfTvs();

		newOffer.setDownloadSpeed();

		newOffer.setUploadSpeed();

		newOffer.setActive();

		_offers.add(_persistence.update(newOffer));

		Offer existingOffer = _persistence.findByPrimaryKey(
			newOffer.getPrimaryKey());

		Assert.assertEquals(existingOffer.getId(), newOffer.getId());
		Assert.assertEquals(existingOffer.getType(), newOffer.getType());
		Assert.assertEquals(existingOffer.getTitle(), newOffer.getTitle());
		Assert.assertEquals(
			existingOffer.getDescription(), newOffer.getDescription());
		Assert.assertEquals(
			existingOffer.getMobileData(), newOffer.getMobileData());
		Assert.assertEquals(
			existingOffer.getMobileMinutes(), newOffer.getMobileMinutes());
		Assert.assertEquals(
			existingOffer.getMobileSms(), newOffer.getMobileSms());
		Assert.assertEquals(
			existingOffer.getProgramsNumber(), newOffer.getProgramsNumber());
		Assert.assertEquals(
			existingOffer.getDefaultNumberOfTvs(),
			newOffer.getDefaultNumberOfTvs());
		Assert.assertEquals(
			existingOffer.getDownloadSpeed(), newOffer.getDownloadSpeed());
		Assert.assertEquals(
			existingOffer.getUploadSpeed(), newOffer.getUploadSpeed());
		Assert.assertEquals(existingOffer.getActive(), newOffer.getActive());
	}

	@Test
	public void testCountBytype() throws Exception {
		_persistence.countBytype("");

		_persistence.countBytype("null");

		_persistence.countBytype((String)null);
	}

	@Test
	public void testCountBytypeAndActive() throws Exception {
		_persistence.countBytypeAndActive("", (Boolean)null);

		_persistence.countBytypeAndActive("null", (Boolean)null);

		_persistence.countBytypeAndActive((String)null, (Boolean)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Offer newOffer = addOffer();

		Offer existingOffer = _persistence.findByPrimaryKey(
			newOffer.getPrimaryKey());

		Assert.assertEquals(existingOffer, newOffer);
	}

	@Test(expected = NoSuchOfferException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Offer> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"SP_Offer", "id", true, "type", true, "title", true, "description",
			true, "mobileData", true, "mobileMinutes", true, "mobileSms", true,
			"programsNumber", true, "defaultNumberOfTvs", true, "downloadSpeed",
			true, "uploadSpeed", true, "active", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Offer newOffer = addOffer();

		Offer existingOffer = _persistence.fetchByPrimaryKey(
			newOffer.getPrimaryKey());

		Assert.assertEquals(existingOffer, newOffer);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Offer missingOffer = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOffer);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Offer newOffer1 = addOffer();
		Offer newOffer2 = addOffer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOffer1.getPrimaryKey());
		primaryKeys.add(newOffer2.getPrimaryKey());

		Map<Serializable, Offer> offers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, offers.size());
		Assert.assertEquals(newOffer1, offers.get(newOffer1.getPrimaryKey()));
		Assert.assertEquals(newOffer2, offers.get(newOffer2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Offer> offers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(offers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Offer newOffer = addOffer();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOffer.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Offer> offers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, offers.size());
		Assert.assertEquals(newOffer, offers.get(newOffer.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Offer> offers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(offers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Offer newOffer = addOffer();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOffer.getPrimaryKey());

		Map<Serializable, Offer> offers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, offers.size());
		Assert.assertEquals(newOffer, offers.get(newOffer.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			OfferLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Offer>() {

				@Override
				public void performAction(Offer offer) {
					Assert.assertNotNull(offer);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Offer newOffer = addOffer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Offer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newOffer.getId()));

		List<Offer> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Offer existingOffer = result.get(0);

		Assert.assertEquals(existingOffer, newOffer);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Offer.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextLong()));

		List<Offer> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Offer newOffer = addOffer();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Offer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newOffer.getId();

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
			Offer.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Offer addOffer() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Offer offer = _persistence.create(pk);

		offer.setType(RandomTestUtil.randomString());

		offer.setTitle(RandomTestUtil.randomString());

		offer.setDescription(RandomTestUtil.randomString());

		offer.setMobileData();

		offer.setMobileMinutes();

		offer.setMobileSms();

		offer.setProgramsNumber();

		offer.setDefaultNumberOfTvs();

		offer.setDownloadSpeed();

		offer.setUploadSpeed();

		offer.setActive();

		_offers.add(_persistence.update(offer));

		return offer;
	}

	private List<Offer> _offers = new ArrayList<Offer>();
	private OfferPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}