package org.shtiroy.parse.infobase.repository;

import org.shtiroy.parse.infobase.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = " select t1.* " +
                   " from company t1" +
                   " where company_type = 'Societate cu răspundere limitată' " +
                   " and LENGTH(t1.idno) = 13" +
                   " and t1.date_end is null " +
                   " and not exists(select 1 from company_json t2 where t2.idno = t1.idno)" +
                   " fetch first 1000 rows only",
            nativeQuery = true)
    List<Company> findAllActiveCompany();
}
