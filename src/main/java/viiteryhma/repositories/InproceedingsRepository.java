/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viiteryhma.repositories;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import viiteryhma.model.Inproceedings;
 
@Repository
public interface InproceedingsRepository extends JpaRepository<Inproceedings, Long> {

 
}