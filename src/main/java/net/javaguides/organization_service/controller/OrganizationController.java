package net.javaguides.organization_service.controller;

import lombok.AllArgsConstructor;
import net.javaguides.organization_service.dto.OrganizationDTO;
import net.javaguides.organization_service.entity.Organization;
import net.javaguides.organization_service.mapper.OrganizationMapper;
import net.javaguides.organization_service.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO )
    {
       OrganizationDTO savedOrganization =   organizationService.saveOrganization ( organizationDTO );
       return new ResponseEntity<> ( savedOrganization, HttpStatus.CREATED ) ;
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDTO> getOrganizationByCode (@PathVariable(name = "code") String organizationCode){
       OrganizationDTO orgDTO =  organizationService.getOrganizationByCode ( organizationCode );
       return new ResponseEntity<> ( orgDTO, HttpStatus.CREATED );
    }

}
