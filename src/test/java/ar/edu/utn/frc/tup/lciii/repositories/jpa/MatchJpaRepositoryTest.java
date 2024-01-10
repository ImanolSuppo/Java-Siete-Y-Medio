package ar.edu.utn.frc.tup.lciii.repositories.jpa;

import ar.edu.utn.frc.tup.lciii.entities.MatchEntity;
import ar.edu.utn.frc.tup.lciii.entities.PlayerEntity;
import ar.edu.utn.frc.tup.lciii.entities.RoundEntity;
import ar.edu.utn.frc.tup.lciii.helpers.MatchHelper;
import ar.edu.utn.frc.tup.lciii.helpers.PlayerHelper;
import ar.edu.utn.frc.tup.lciii.models.MatchStatus;
import ar.edu.utn.frc.tup.lciii.models.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
class MatchJpaRepositoryTest {

    @MockBean
    private MatchJpaRepository matchRepository;
    @Autowired
    private MatchJpaRepository matchJpaRepository;
    @Autowired
    private RoundJpaRepository roundJpaRepository;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Test
    void getAllByPlayerIdAndMatchStatusTest() {
        // TODO: Completar el Test para validar que el metodo
        //  getAllByPlayerIdAndMatchStatus(Long playerId, MatchStatus matchStatus)
        //  de la clase MatchJpaRepository funciona.
        Optional<List<MatchEntity>> matchEntity = matchJpaRepository.getAllByPlayerIdAndMatchStatus(1L, MatchStatus.FINISH);
        assertFalse(matchEntity.isPresent());
    }
    @Test
    void getAllByPlayerIdAndMatchStatusTest2() {
        // TODO: Completar el Test para validar que el metodo
        //  getAllByPlayerIdAndMatchStatus(Long playerId, MatchStatus matchStatus)
        //  de la clase MatchJpaRepository funciona.
        PlayerEntity player = PlayerHelper.getPlayerEntity("ima@gmail.com", BigDecimal.valueOf(1000));
        List<RoundEntity> rounds = new ArrayList<>();
        MatchEntity matchEntity = MatchHelper.getMatchEntity(player, MatchStatus.FINISH, rounds);
        List<MatchEntity> matchEntityList = new ArrayList<>();
        matchEntityList.add(matchEntity);
        when(matchRepository.getAllByPlayerIdAndMatchStatus(1L, MatchStatus.FINISH)).thenReturn(Optional.of(matchEntityList));
        assertEquals(matchRepository.getAllByPlayerIdAndMatchStatus(1L, MatchStatus.FINISH).get(), matchEntityList);
    }
}