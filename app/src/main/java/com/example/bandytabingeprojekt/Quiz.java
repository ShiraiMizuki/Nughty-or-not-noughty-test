package com.example.bandytabingeprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Quiz extends AppCompatActivity {
    Random random = new Random();
    int aktualnepytanie;
    Button odp1, odp2, odp3, odp4;
    TextView pytanie , ktorepytanie;
    int punkty=1 , licznikpytan=1;
    HashMap<Integer, List<String>> pytaniaodp = new HashMap<>();
    String wartoscp , poprawne;

    void losulosu() {
         aktualnepytanie = random.nextInt(20) + 1;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            //STRUKTURA LISTY 0 PYTANIE | 1 ODP | 2 ODP | 3 ODP | 4 ODP | 5 POPRAWNA NUMER
            pytaniaodp.put(1, Arrays.asList("Brat zbił bombkę – rodzice mogą się wkurzyć. Co robisz?", "Krzyczysz dyskretnie i sprzątasz sam."
                    ,"Pomagasz, pocieszasz i uczysz ostrożności."
                    ,"Śmiejesz się, robisz zdjęcie na pamiątkę."
                    , "Obwin go przed rodzicami."
                    , "2"));
            pytaniaodp.put(2, Arrays.asList("Prezent ci się nie podoba jak reagujesz?", "Rzucasz w kąt po kolacji."
                    ,"Mówisz szczerze i proponujesz wymianę."
                    ,"Dziękujesz, doceniasz."
                    , "Ukrywasz i udajesz."
                    , "3"));

            pytaniaodp.put(3, Arrays.asList("Resztki po wigilii ,co z nimi?", "Rzucasz w rodzeństwo dla żartu."
                    ,"Wyrzucasz szybko do śmieci."
                    ,"Zostawiasz bałagan rodzicom."
                    , "Sprzątasz, pakujesz dla potrzebujących."
                    , "4"));

            pytaniaodp.put(4, Arrays.asList("Elf ma problem z pakowaniem i opóźni to twoją zabawę?", "Pomagasz, pakowac razem"
                    ,"Śmiejesz się, dajesz szybką radę."
                    ,"Kradniesz dyskretnie jeden prezent."
                    , "Przeszkadzasz, lekko, potem przepraszasz."
                    , "1"));

            pytaniaodp.put(5, Arrays.asList("Zwierze boi się hałasu a twoi znajomi jeszcze pogaraszają sytuację ", "Gonisz je dla zabawy."
                    ,"Dbasz o nie dajesz smakołyki, chronisz przed hałasem."
                    ,"Dajesz resztki, co mogą zaszkodzić."
                    , "Ignoruj ,jestes potrzebny w zabawie."
                    , "2"));

            pytaniaodp.put(6, Arrays.asList("Ktoś jest smutny przy stole ", "Powiedz żę nie ma psuć zabawy."
                    ,"Śmiej się z ich smutku."
                    ,"Rozmawiaj, rozweselaj."
                    , "Unikasz i bawisz się sam."
                    , "3"));

            pytaniaodp.put(7, Arrays.asList("CO zrobisz gdy zobaczysz świętego mikołaja ", "Podglądasz prezenty."
                    ,"Kłamiesz o zachowaniu."
                    ,"Wymuszasz lepsze prezenty."
                    , "Jesteś grzeczny, dziękujesz za odwiedziny"
                    , "4"));

            pytaniaodp.put(8, Arrays.asList("Choinka po świętach – co z nią? ", " Ściągasz ozodby i zostawiasz na następny rok"
                    ,"Zostaw igły, nie sprzątaj"
                    ,"Niszcz ozdoby."
                    , "Narzekaj ,strata czasu."
                    , "1"));

            pytaniaodp.put(9, Arrays.asList("Przegrywasz grę z kumplami – reakcja?", "Wścieknij się, wyjdź."
                    ,"Pogratuluj, zaproponuj. rewanż."
                    ,"Oszukaj ich następnym razem."
                    , "Obwin innych."
                    , "2"));

            pytaniaodp.put(10, Arrays.asList("Bezdomny w święta – co robisz? ", "omijaj szerokim łukiem."
                    ,"Śmiej się z nim."
                    ,"Daj mu posiłek lub datek."
                    , "Daj mu alkohol"
                    , "3"));

            pytaniaodp.put(11, Arrays.asList("Dzielisz się z rodzeństwem? ", "Nie dzielisz się "
                    ,"Bierzesz ich rzeczy bez pytania."
                    ,"Wymuszasz ich rzeczy."
                    , "Dajesz coś od siebie."
                    , "4"));
            pytaniaodp.put(12, Arrays.asList("Śpiewasz kolędy z rodziną ", "Śpiewasz radośnie."
                    ,"Śmiejesz się z fałszujących."
                    ,"Udajesz, że nie znasz tekstu."
                    , "Przerywasz dla żartu."
                    , "1"));
            pytaniaodp.put(13, Arrays.asList("Za dużo słodyczy – co z nimi? ", "Zjadasz sam w ukryciu."
                    ,"Dzielisz się z innymi."
                    ,"Rzucasz w innych."
                    , "Chowasz i milczysz."
                    , "2"));
            pytaniaodp.put(14, Arrays.asList("Fajerwerki straszą zwierzaki? ", "Śmiejesz się z ich strachu."
                    ,"Puszczasz więcej."
                    ,"Uspokajasz, chronisz."
                    , "Ignorujesz i patrzysz."
                    , "3"));
            pytaniaodp.put(15, Arrays.asList("Kolega zapomniał prezentu w szatni", "Zabierasz dla siebie."
                    ,"Otwierasz, żeby sprawdzić co jest w środku."
                    ,"Mówisz wszystkim dla śmiechu."
                    , "Oddajesz dyskretnie."
                    , "4"));
            pytaniaodp.put(16, Arrays.asList("Dekorowanie choinki ", "Wieszasz ozdoby, dzielisz się miejscem."
                    ,"Wieszasz tylko na górze."
                    ,"Zbijasz „przypadkiem” ozdoby."
                    , "Patrzysz, jak inni dekorują."
                    , "1"));
            pytaniaodp.put(17, Arrays.asList("Sanie Mikołaja zatrzymały się w zaspie ", "Śmiejesz się i nagrywasz."
                    ,"Popychasz razem z elfami."
                    ,"Podkładasz głaz."
                    , "Czekasz na innych."
                    , "2"));
            pytaniaodp.put(18, Arrays.asList("Przyjaciel przeprasza za psikus? ", "Nie wybaczaszasz, złościsz się."
                    ,"Mścisz się."
                    ,"Wybaczasz, śmiejecie się razem."
                    , "Opowiadasz wszystkim."
                    , "3"));
            pytaniaodp.put(19, Arrays.asList("Papier po prezentach – co z nim zrobisz ", "Rzucasz na podłogę."
                    ,"Robisz kulki i zaczynasz walkę."
                    ,"Zostawiasz to mamie."
                    , "Zbierasz i wyrzucasz do kosza."
                    , "4"));
            pytaniaodp.put(20, Arrays.asList("Życzenia świąteczne – jak składasz? ", "Szczerze, z serca."
                    ,"Meh, wesołych"
                    ,"Śmieszne lub obraźliwe."
                    , "Wzajemnie"
                    , "1"));
             odp1 = findViewById(R.id.Odp1);
             odp2 = findViewById(R.id.Odp2);
             odp3 = findViewById(R.id.Odp3);
             odp4 = findViewById(R.id.Odp4);
            pytanie = findViewById(R.id.pytanie);
            ktorepytanie = findViewById(R.id.ktorepytanie);
            ktorepytanie.setText(licznikpytan+"/10");
            updatebuttons();
// i know that i could do it more effectivly but im too lazy and it looks funny
            return insets;

        });


    }

    void updatebuttons(){
        losulosu();
        System.out.println(aktualnepytanie);
        List<String> dane = pytaniaodp.get(aktualnepytanie);
        String p = dane.get(0);
        String o1 = dane.get(1);
        String o2 = dane.get(2);
        String o3 = dane.get(3);
        String o4 = dane.get(4);
         poprawne = dane.get(5);
        odp1.setText(o1);
        odp2.setText(o2);
        odp3.setText(o3);
        odp4.setText(o4);
        pytanie.setText(p);
        odp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wartoscp = "1";
                sprawdzczyprawidlowa();
            }
        });
        odp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wartoscp = "2";
                sprawdzczyprawidlowa();
            }
        });
        odp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wartoscp = "3";
                sprawdzczyprawidlowa();
            }
        });
        odp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wartoscp = "4";
                sprawdzczyprawidlowa();
            }

        });

    }
       void sprawdzczyprawidlowa(){
        if(licznikpytan > 9 ){
            int finalpunkty =punkty;
            if(punkty >6){
                Intent intent = new Intent(Quiz.this , zdane.class);
                intent.putExtra("punkty", punkty);
                startActivity(intent);
            }else {
                Intent intent = new Intent(Quiz.this , niezdane.class);
                startActivity(intent);
            }
        }
              if(wartoscp == poprawne){
                punkty++;
                  updatebuttons();
                  licznikpytan++;
                  ktorepytanie.setText(licznikpytan+"/10");
              }else {
                  updatebuttons();
                  licznikpytan++;
                  ktorepytanie.setText(licznikpytan+"/10");
              }
       }
    }

