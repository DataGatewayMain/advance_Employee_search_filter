package total.people.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import total.people.entity.People;
//import total.people.entity.Entity;
import total.people.repo.peopleRepository;

import java.util.List;
import java.util.Map;

public class peopleCaching {

	@Autowired
    private peopleRepository prospectRepository;

    @Cacheable(value = "prospects", key = "#includeFilters + #excludeFilters + #page + #size")
    public Page<People> searchProspects(Map<String, String> includeFilters, Map<String, String> excludeFilters, int page, int size) {
        Specification<People> specification = peopleSpecification.getSpecifications(includeFilters, excludeFilters);
        Pageable pageable = PageRequest.of(page, size);
        return prospectRepository.findAll(specification, pageable);
    }
	
}
