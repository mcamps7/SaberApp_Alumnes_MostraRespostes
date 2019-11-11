/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.saberAppMostraRespostes.content;

import com.example.android.saberAppMostraRespostes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample song content.
 */
public class RespostesUtils {

    // An ArrayList of Preguntes
    public static final List<Pregunta> PREGUNTA_ITEMS = new ArrayList<>();

    // The ID for the index into preguntes titles.
    public static final String PREGUNTA_ID_KEY = "item_id";

    // The number of preguntes
    private static final int COUNT = 8;

    /**
     * A Pregunta item represents a pregunta title, and pregunta details.
     */
    public static class Pregunta {
        public final String pregunta_title;
        public final String details;
        public final int idImage;

        private Pregunta(String content, String details, int image) {
            this.pregunta_title = content;
            this.details = details;
            this.idImage = image;
        }
    }

    /**
     * Add an item to the array.
     *
     * @param item Each pregunta
     */
    private static void addItem(Pregunta item) {
        PREGUNTA_ITEMS.add(item);
    }

    static {
        // Fill the array with preguntes.
        for (int i = 0; i < COUNT; i++) {
            addItem(createPreguntaAtPosition(i));
        }
    }

    private static Pregunta createPreguntaAtPosition(int position) {
        String newTitle;
        String newDetail;
        int newImage;

        switch (position) {
            case 0:
                newTitle = "Quin any es va pintar aquest quadre?";
                newDetail = "1889\n\nLa nit estrellada va ser pintada per Vincent Van Gogh el 1889 des des de la finestra del sanatori de Sant Romieg de Provença.\nEs tracta d'un paisatge pintat a l'oli d'estil postimpressionista.";
                newImage = R.drawable.nit;
            break;
            case 1:
                newTitle = "\"I'll be your mirror\" és el tema que dona nom a aquesta obra. Quin és el nom de la banda de rock autora de la peça musical?";
                newDetail = "The velvet underground\n\n\"I'll be your mirror\" és el tema que dona nom a aquesta obra de la portuguesa Joana Vasconcelos. La cançó parla de la identitat i la necessitat de descobrir la pròpia escència. Però, per sobre de tot, la música expresa el desig de veure's i de reconèixer-se en l'altre. En aquesta obra, Vasconcelos també aludeix a aquesta idea.\n\"I'm your mirror\" és una enorme màscara veneciana construida per 462 miralls. És una obra del 2018 que només ha estat exposada a Bilbao, Porto i Rotterdam.\n" +
                        "Com en altres ocasions, l'artista portugesa Joana Vasconcelos fa servir un objecte quotidià que a tothom ens resulta familiar per compondre un element més gran que adquireix un altre sentit. Des d’unes sabates de taló d'agulla fetes amb olles i cassoles fins a canelobres de tampons, l’obra de la creadora sempre ha explorat nocions de feminitat. \n" +
                        "La cançó que dóna títol a l'escultura, \"I'll be your mirror\", és del primer disc de la banda de Nova York \"The Velvet Underground\" publicada l'any 1967.";
                newImage = R.drawable.joana;
                break;
            case 2:
                newTitle = "Com s'anomena aquest poliedre regular?";
                newDetail = "Icosàedre\n\nÉs un poliedre regular convex de 20 cares, on cada cara és un triangle equilater. Té, també,12 vèrtex i 30 arestes.\n" +
                        "És un dels cinc sòlids platònics juntament amb el tetràedre, el cub, l'octàedre i el dodecàedre.";
                newImage = R.drawable.icosaedre;
                break;
            case 3:
                newTitle = "Com s'anomenen els colors oposats en el cercle cromàtic?";
                newDetail = "Colors complementaris\n\nEls colors oposats en el cercle cromàtic es complementen. És a dir en la composició d'un, no hi ha cap rastre de l'oposat. \n" +
                        "Per exemple, el verd (groc+cyan) es complementa amb el magenta. \n" +
                        "Un primari sempre té com a complementari el secundari creat amb els altres dos colors primaris. \n" +
                        "Una característica dels colors complementaris és que es relacionen per contrast. ";
                newImage = R.drawable.colors;
                break;
            case 4:
                newTitle = "Quin famós quadre de Picasso va estar exposat en un concessionari de cotxes durant el 1939?";
                newDetail = "El Guernica\n\nA la postguerra (Guerra Civil Espanyola 1936-39), el 1939, un grup d'anglesos, per recapatar fons per al Comitè d'Ajuda als Refugiats Espanyols, van decidir exposar el quadre, però no van trobar galeries suficientment grans per exposar-lo i van haver de recórrer a un concessionari de cotxes.";
                newImage = R.drawable.guernica;
                break;
            case 5:
                newTitle = "Com s'anomena la tècnica que feia servir a l'hora de pintar un dels màxims exponents de l'Expresionisme abstracte americà?";
                newDetail = "Dripping o goteig\n\nLa tècnica pictòrica que utilitza l'artista és el dripping o goteig.\n" +
                        "Jackson Pollock és un dels grans pintors del segle XX. L’Expressionisme abstracte americà va establir un nou camí en la pintura i particularment, Pollock, amb el seu “action painting”, va abanderar tot un impuls de noves intencions tant pictòriques com identitàries d’un país que agafaria el relleu, envers la vella Europa, com a capdavanter davant el context artístic del moment.";
                newImage = R.drawable.pollock;
                break;
            case 6:
                newTitle = "Pots reconèixer aquest museu i dir a on es situa?";
                newDetail = "Museu Guggenheim de Bilbao\n\nÉs un museu d'art contemporani situat a Bilbao (País Vasc), obra del gabinet d'arquitectes Frank Gehry. Va obrir les portes al públic al 1997.\n" +
                        "És un dels edificis més espectaculars dins de l'arquitectura post-moderna. Totes les seves formes són orgàniques, no té cap façana recta. Està recobert de plaques de titani i de pedra calcària difícil de trobar.";
                newImage = R.drawable.guggenheim;
                break;
            default:
                newTitle = "El bròquil romanescu té una forma molt especial. Com s'anomena l'estructura que té?";
                newDetail = "Estructura fractal\n\nUna fractal és una forma geomètrica complexa que té la característica d'assemblar-se a si mateixa a diferents escales d'observació.\n" +
                        "En el cas del bròquil romanescu l'articulació fractal creix exponencialment en 3D des del vèrtex d'un con i de forma helicoidal.";
                newImage = R.drawable.brocoli;
                break;
        }
        return new Pregunta(newTitle, newDetail, newImage);
    }
}
