/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package de.uhh.l2g.plugins.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Facility_HostLocalService}.
 *
 * @author Iavor Sturm
 * @see Facility_HostLocalService
 * @generated
 */
public class Facility_HostLocalServiceWrapper
	implements Facility_HostLocalService,
		ServiceWrapper<Facility_HostLocalService> {
	public Facility_HostLocalServiceWrapper(
		Facility_HostLocalService facility_HostLocalService) {
		_facility_HostLocalService = facility_HostLocalService;
	}

	/**
	* Adds the facility_ host to the database. Also notifies the appropriate model listeners.
	*
	* @param facility_Host the facility_ host
	* @return the facility_ host that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Facility_Host addFacility_Host(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.addFacility_Host(facility_Host);
	}

	/**
	* Creates a new facility_ host with the primary key. Does not add the facility_ host to the database.
	*
	* @param fasilityHostId the primary key for the new facility_ host
	* @return the new facility_ host
	*/
	@Override
	public de.uhh.l2g.plugins.model.Facility_Host createFacility_Host(
		long fasilityHostId) {
		return _facility_HostLocalService.createFacility_Host(fasilityHostId);
	}

	/**
	* Deletes the facility_ host with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host that was removed
	* @throws PortalException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Facility_Host deleteFacility_Host(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.deleteFacility_Host(fasilityHostId);
	}

	/**
	* Deletes the facility_ host from the database. Also notifies the appropriate model listeners.
	*
	* @param facility_Host the facility_ host
	* @return the facility_ host that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Facility_Host deleteFacility_Host(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.deleteFacility_Host(facility_Host);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _facility_HostLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public de.uhh.l2g.plugins.model.Facility_Host fetchFacility_Host(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.fetchFacility_Host(fasilityHostId);
	}

	/**
	* Returns the facility_ host with the primary key.
	*
	* @param fasilityHostId the primary key of the facility_ host
	* @return the facility_ host
	* @throws PortalException if a facility_ host with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Facility_Host getFacility_Host(
		long fasilityHostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.getFacility_Host(fasilityHostId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the facility_ hosts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.Facility_HostModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of facility_ hosts
	* @param end the upper bound of the range of facility_ hosts (not inclusive)
	* @return the range of facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<de.uhh.l2g.plugins.model.Facility_Host> getFacility_Hosts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.getFacility_Hosts(start, end);
	}

	/**
	* Returns the number of facility_ hosts.
	*
	* @return the number of facility_ hosts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getFacility_HostsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.getFacility_HostsCount();
	}

	/**
	* Updates the facility_ host in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param facility_Host the facility_ host
	* @return the facility_ host that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public de.uhh.l2g.plugins.model.Facility_Host updateFacility_Host(
		de.uhh.l2g.plugins.model.Facility_Host facility_Host)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.updateFacility_Host(facility_Host);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _facility_HostLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_facility_HostLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _facility_HostLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getByFacilityId(long facilityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.getByFacilityId(facilityId);
	}

	@Override
	public de.uhh.l2g.plugins.model.Host getByHostId(long hostId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _facility_HostLocalService.getByHostId(hostId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public Facility_HostLocalService getWrappedFacility_HostLocalService() {
		return _facility_HostLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedFacility_HostLocalService(
		Facility_HostLocalService facility_HostLocalService) {
		_facility_HostLocalService = facility_HostLocalService;
	}

	@Override
	public Facility_HostLocalService getWrappedService() {
		return _facility_HostLocalService;
	}

	@Override
	public void setWrappedService(
		Facility_HostLocalService facility_HostLocalService) {
		_facility_HostLocalService = facility_HostLocalService;
	}

	private Facility_HostLocalService _facility_HostLocalService;
}