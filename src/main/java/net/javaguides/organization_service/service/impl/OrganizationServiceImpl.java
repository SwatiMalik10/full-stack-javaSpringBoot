package net.javaguides.organization_service.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organization_service.dto.OrganizationDTO;
import net.javaguides.organization_service.entity.Organization;
import net.javaguides.organization_service.mapper.OrganizationMapper;
import net.javaguides.organization_service.repository.OrganizationRepository;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl  implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO saveOrganization ( OrganizationDTO organizationDTO ) {
        //convert organizationDTo into Organization jpa entity
        Organization organization = OrganizationMapper.mapToOrganization (organizationDTO  );
        Organization savedEntity = organizationRepository.save ( organization ); // create JPA entity

        return OrganizationMapper.mapToOrganizationDTO ( savedEntity );
    }

    @Override
    public OrganizationDTO getOrganizationByCode ( String organizationCode ) {
      Organization organization  =    organizationRepository.findOrganizationByOrganizationCode ( organizationCode );
        return OrganizationMapper.mapToOrganizationDTO ( organization );
       // return null;
    }
}
