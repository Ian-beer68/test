package org.ian.gohenry.endpoints;

import org.ian.gohenry.domain.Parent;
import org.ian.gohenry.dto.ParentDTO;
import org.ian.gohenry.service.FamilyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/parents")
public class ParentEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(ParentEndpoint.class);
    @Autowired
    private FamilyService familyService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private Validator validator;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity createParent(@RequestBody ParentDTO parent) {

        final Set<ConstraintViolation<ParentDTO>> violations = validator.validate(parent);
        if (!violations.isEmpty()) {
            final Map<String, String> errors = new ConcurrentHashMap<>(1);
            for (final ConstraintViolation violation : violations) {
                errors.put(violation.getPropertyPath().toString(),
                        violation.getMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Parent p = convertFromDTO(parent);

        p = familyService.createParent(p);

        ParentDTO dto = convertToDTO(p);

//        Resource<ParentDTO> resource = new Resource<>(dto);
//        ControllerLinkBuilder linkto = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getParentWithChildren(dto.getId()));
//        resource.add(linkto.withRel("self"));

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping(path = "/{parent_id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getParentWithChildren(@PathVariable("parent_id") Long parentId) {
        Parent parent = familyService.getParentPlusChildren(parentId);
        if (null == parent) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        ParentDTO dto = convertToDTO(parent);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    private Parent convertFromDTO(ParentDTO dto) {
        Parent p = modelMapper.map(dto, Parent.class);

        return p;
    }

    private ParentDTO convertToDTO(Parent parent) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        ParentDTO dto = modelMapper.map(parent, ParentDTO.class);

        return dto;
    }
}
