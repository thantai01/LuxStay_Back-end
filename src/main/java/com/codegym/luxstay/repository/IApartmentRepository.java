package com.codegym.luxstay.repository;

import com.codegym.luxstay.model.Apartment;
import com.codegym.luxstay.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Repository
public interface IApartmentRepository extends JpaRepository<Apartment, Long> {
    Iterable<Apartment> findAllByNameContaining(String name);
    Iterable<Apartment> findAllByStatusContaining(String status);
    Iterable<Apartment> findAllByPriceContaining(String price);
    Iterable<Apartment> findAllByApartmentTypeContaining(String type);
    Iterable<Apartment> findAllByDescriptionContaining(String description);



    @Modifying
    @Query(value = "Select *,count(o.apartment_id) from Apartment a left join Orders o on o.apartment_id = a.id group by o.apartment_id order by count(o.apartment_id) desc limit 5", nativeQuery = true)
    Iterable<Apartment> findTop5();

    @Query(value = "select * from Apartment a where a.status like 'not available'", nativeQuery = true)
    Iterable<Apartment> findApartmentNotAvailable();

    @Query(value = "select * from Apartment a where a.status like 'available'", nativeQuery = true)
    Iterable<Apartment> findApartmentAvailable();


    @Modifying
    @Query(value = "select * from apartment where apartment.user_id = ?1", nativeQuery = true)
    Iterable<Apartment> findAllByUserId(long id);

    Iterable<Apartment> findAllByAddressContaining(@NotBlank @Size(min = 3) String address);
    Iterable<Apartment> findAllByCityContaining(@NotBlank String city);
    Iterable<Apartment> findAllByCityContainingAndDistrictContainingAndWardContaining(
            @NotBlank String city, @NotBlank String district, @NotBlank String ward);
}
