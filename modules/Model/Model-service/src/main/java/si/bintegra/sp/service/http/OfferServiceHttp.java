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

package si.bintegra.sp.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import si.bintegra.sp.service.OfferServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>OfferServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OfferServiceHttp {

	public static java.util.List<si.bintegra.sp.model.Offer> findActiveByType(
		HttpPrincipal httpPrincipal, String type) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "findActiveByType",
				_findActiveByTypeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, type);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<si.bintegra.sp.model.Offer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static si.bintegra.sp.model.Offer findById(
			HttpPrincipal httpPrincipal, Long id)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "findById", _findByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						si.bintegra.sp.exception.NoSuchOfferException) {

					throw (si.bintegra.sp.exception.NoSuchOfferException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (si.bintegra.sp.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static si.bintegra.sp.model.Offer addOffer(
		HttpPrincipal httpPrincipal, String title, String type,
		String description, Boolean active, Long mobileData, Long mobileMinutes,
		Long mobileSms, Long programsNumber, Long defaultNumberOfTvs,
		Long downloadSpeed, Long uploadSpeed) {

		try {
			MethodKey methodKey = new MethodKey(
				OfferServiceUtil.class, "addOffer", _addOfferParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, type, description, active, mobileData,
				mobileMinutes, mobileSms, programsNumber, defaultNumberOfTvs,
				downloadSpeed, uploadSpeed);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (si.bintegra.sp.model.Offer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(OfferServiceHttp.class);

	private static final Class<?>[] _findActiveByTypeParameterTypes0 =
		new Class[] {String.class};
	private static final Class<?>[] _findByIdParameterTypes1 = new Class[] {
		Long.class
	};
	private static final Class<?>[] _addOfferParameterTypes2 = new Class[] {
		String.class, String.class, String.class, Boolean.class, Long.class,
		Long.class, Long.class, Long.class, Long.class, Long.class, Long.class
	};

}