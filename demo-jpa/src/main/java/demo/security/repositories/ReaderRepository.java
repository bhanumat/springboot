package demo.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.security.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, String> {
}