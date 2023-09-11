package com.ppa.liitja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LiitjaKontroller {
    // Arvutuste talletamise massiiv.
    private List<LiitjaOperandid> tehted = new ArrayList<>();

    // GET Meetod nr 1.
    @GetMapping("/liida")
    public LiitjaOperandid liidaArvud(

            // Sisendid.
            @RequestParam("arv1") int arv1,
            @RequestParam("arv2") int arv2) {

        if (onLubatudSisend(arv1) && onLubatudSisend(arv2)) {

            // Sisend on kontrollitud. Loo uus objekt sisenditest.
            LiitjaOperandid operandid = new LiitjaOperandid();
            operandid.setArv1(arv1);
            operandid.setArv2(arv2);
            operandid.setSumma(arv1 + arv2);

            // Lisa objekt masiivi.
            tehted.add(operandid);

            // Tagasta teenuse väljundis objekt.
            return operandid;
        } else {
            throw new IllegalArgumentException("Viga sisendis! Lubatud vahemikk arvudele: 0 - 100.");
        }
    }

    // GET Meetod nr 2.
    @GetMapping("/otsing")
    public List<LiitjaOperandid> otsiTehteid(

            // Sisendid.
            @RequestParam(name = "arv", required = false) Integer x,
            @RequestParam(name = "jarjestus") String jarjestus) {

        // Täisarvu olemasolu ja sisendi kontroll.
        if (x != null) {
            if (onLubatudSisend(x)) {
                tehted = tehted.stream()
                        .filter(op -> op.getArv1() == x || op.getArv2() == x || op.getSumma() == x)
                        .collect(Collectors.toList());
            } else {
                throw new IllegalArgumentException("Vigane sorteerimisatribuut. Lubatud vahemikk arvule: 0 - 100.");
            }
        }

        // Sorteeri ja kuva masiiv vastavalt sisendile.
        if ("kasvav".equalsIgnoreCase(jarjestus)) {
            tehted.sort(Comparator.comparingInt(LiitjaOperandid::getSumma));
        } else if ("kahanev".equalsIgnoreCase(jarjestus)) {
            tehted.sort(Comparator.comparingInt(LiitjaOperandid::getSumma).reversed());
        } else {
            throw new IllegalArgumentException("Vigane sorteerimisatribuut. Kasuta kas 'kasvav' või 'kahanev'.");
        }

        return tehted;
    }

    // Sisendit kontrolliv abifunktsioon.
    private boolean onLubatudSisend(int arv) {
        return arv >= 0 && arv <= 100;
    }
}
