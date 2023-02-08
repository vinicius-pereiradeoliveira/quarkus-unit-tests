package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Company;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements PanacheRepository<Company> {
}
