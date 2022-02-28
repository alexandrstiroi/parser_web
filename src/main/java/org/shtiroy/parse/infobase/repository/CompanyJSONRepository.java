package org.shtiroy.parse.infobase.repository;

import org.shtiroy.parse.infobase.entity.CompanyJSON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJSONRepository extends JpaRepository<CompanyJSON, Integer> {

}
