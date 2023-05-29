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

import si.bintegra.sp.service.PackageOfferServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>PackageOfferServiceUtil</code> service
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
public class PackageOfferServiceHttp {

	public static java.util.List<si.bintegra.sp.model.PackageOffer>
		findActiveByOfferId(HttpPrincipal httpPrincipal, Long id) {

		try {
			MethodKey methodKey = new MethodKey(
				PackageOfferServiceUtil.class, "findActiveByOfferId",
				_findActiveByOfferIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<si.bintegra.sp.model.PackageOffer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static si.bintegra.sp.model.PackageOffer findById(
			HttpPrincipal httpPrincipal, Long id)
		throws si.bintegra.sp.exception.NoSuchPackageOfferException {

		try {
			MethodKey methodKey = new MethodKey(
				PackageOfferServiceUtil.class, "findById",
				_findByIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, id);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						si.bintegra.sp.exception.NoSuchPackageOfferException) {

					throw (si.bintegra.sp.exception.NoSuchPackageOfferException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (si.bintegra.sp.model.PackageOffer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<si.bintegra.sp.model.PackageOffer>
			findActiveByOfferType(HttpPrincipal httpPrincipal, String type)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		try {
			MethodKey methodKey = new MethodKey(
				PackageOfferServiceUtil.class, "findActiveByOfferType",
				_findActiveByOfferTypeParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, type);

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

			return (java.util.List<si.bintegra.sp.model.PackageOffer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static si.bintegra.sp.model.PackageOffer createPackageOffer(
			HttpPrincipal httpPrincipal, Long offerId, Long fullDuration,
			Long discountDuration, Double discountPrice, Double basePrice,
			Boolean active)
		throws si.bintegra.sp.exception.NoSuchOfferException {

		try {
			MethodKey methodKey = new MethodKey(
				PackageOfferServiceUtil.class, "createPackageOffer",
				_createPackageOfferParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, offerId, fullDuration, discountDuration,
				discountPrice, basePrice, active);

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

			return (si.bintegra.sp.model.PackageOffer)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PackageOfferServiceHttp.class);

	private static final Class<?>[] _findActiveByOfferIdParameterTypes0 =
		new Class[] {Long.class};
	private static final Class<?>[] _findByIdParameterTypes1 = new Class[] {
		Long.class
	};
	private static final Class<?>[] _findActiveByOfferTypeParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _createPackageOfferParameterTypes3 =
		new Class[] {
			Long.class, Long.class, Long.class, Double.class, Double.class,
			Boolean.class
		};

}