package net.javaguides.organization_service.service;

import net.javaguides.organization_service.dto.OrganizationDTO;

public interface OrganizationService {

    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    public OrganizationDTO getOrganizationByCode(String  organizationCode);
}
