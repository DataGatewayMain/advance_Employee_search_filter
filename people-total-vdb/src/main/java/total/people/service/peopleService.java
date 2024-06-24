package total.people.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import total.people.entity.People;
import total.people.repo.peopleRepository;

import java.util.Map;

@Service
public class peopleService {

    @Autowired
    private peopleRepository peopleRepository;

    @Cacheable(value = "prospects", key = "#includeFilters.toString() + #excludeFilters.toString() + '_' + #page + '_' + #size")
    public Page<People> searchProspects(Map<String, String> includeFilters, Map<String, String> excludeFilters, int page, int size) {
        Specification<People> specification = peopleSpecification.getSpecifications(includeFilters, excludeFilters);
        Pageable pageable = PageRequest.of(page, size);
        return peopleRepository.findAll(specification, pageable);
    }
}
