package com.example.recetasdecocina

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RecetaDatabaseHelper (context : Context) : SQLiteOpenHelper(
    context, DATABASE_NAME, null, DATABSE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "recetas.db"
        private const val DATABSE_VERSION = 1
        private const val TABLE_NAME = "recetas"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "nombre"
        private const val COLUMN_INGREDIENTS = "ingredientes"
        private const val COLUMN_STEPS = "modo_de_preparacion"
        private const val COLUMN_TIME = "tiempo_total"

        private const val TABLE_CREATE = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_INGREDIENTS TEXT,
                $COLUMN_STEPS TEXT,
                $COLUMN_TIME TEXT
            )
        """
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(TABLE_CREATE)

        val recetas = listOf(
            Receta(1,
                "Tarta de ganache de chocolate y frambuesa",
                "Galletas Oreo , Mantequilla, Chocolate con leche para postres, Chocolate negro para postres, Nata líquida para montar, Frambuesas, Perlas de chocolate al gusto",
                "Comenzaremos preparando la ganache. Para eso derretimos en el microondas los dos chocolates a intervalos cortos y media potencia, removiendo de vez en cuando para que no se quemen. Una vez fundidos, reservamos. " +
                "Por otra parte calentamos la nata. Vamos añadiéndola en tres veces a la mezcla de chocolates fundidos y removiendo enérgicamente con una espátula de silicona para que se nos haga la emulsión correctamente y nos de lugar a una mezcla sedosa, sin grumos y brillante. Reservamos la ganache tapada con un film transparente pegado a la superficie de la crema, durante unas cuatro horas en nevera hasta que cristalice. " +
                "Para la base, en un molinillo o robot de cocina trituramos las galletas Oreo con su relleno, hasta que formen polvo. Añadimos la mantequilla fundida y removemos hasta que se forme una pasta. Con ella forramos la base y los laterales de un molde desmontable o de un aro de repostería de 18 centímetros de diámetro, este mejor forrado en su interior con cinta de acetato para que después lo podamos desmoldar fácilmente. " +
                "Enfriamos la masa durante una hora en la nevera para que trabe la mantequilla. Una vez pasado el tiempo, echamos la ganache en la base de galletas y decoramos con frambuesas frescas y perlas de chocolate o trocitos de grue de cacao.",
                55),

            Receta(2,
                "Pechuga de pollo con soja, miel y limón",
                "Pechuga de pollo, Salsa de soja, Miel, Zumo de limón, Pimienta negra molida, Cebollino para decorar, Semillas de sésamo para decorar",
                "Hacemos una marinada con la salsa de soja, la miel, el zumo de limón y un poco de pimienta negra. Abrimos la pechuga de pollo y pincelamos bien con la mezcla anterior. Enrollamos sobre sí misma y envolvemos con dos capas de papel film, que quede bien cerrada. " +
                "Calentamos abundante agua en un cacito y, cuando empiece a hervir, introducimos el rollo de pechuga de pollo en su interior. Cocemos a fuego moderado durante diez minutos, apagamos el fuego, tapamos y dejamos atemperar el pollo en el cacito durante 30 minutos. " +
                "Mientras tanto calentamos el sobrante de la marinada en una sartén a fuego suave hasta reducir a la mitad y conseguir una salsa espesa. Sacamos el pollo del agua y esperamos a que enfríe para retirar el envoltorio. Laminamos y pincelamos por todos sus lados con la salsa. " +
                "Servimos, frío o caliente, espolvoreando el pollo con cebollino fresco picado y semillas de sésamo, arroz en blanco, verduras o cualquier otra guarnición de nuestro gusto.",
                20),

            Receta(3,
                "Tarta de queso sin horno",
                "Galletas tipo María 50 g, Mantequilla 20 g, Queso crema 135 g, Leche 100 g, Cuajada en polvo (1 sobre) 12 g, Azúcar glasé 40 g",
                "Comenzamos por la base de galleta y, para ello, machacamos las galletas y las mezclamos bien con la mantequilla, que habremos fundido previamente, hasta obtener una masa homogénea. Las galletas las podemos machacar manualmente en un mortero, en un molinillo eléctrico o dentro de una bolsa y aplastándola con un rodillo. " +
                "Cubrimos la base de nuestro molde con la mezcla de la galleta y la mantequilla, asegurándonos de apretar bien para que quede condensada bien distribuida por la base. Dejamos enfriar mientras preparamos el relleno. Podemos introducirla en la nevera o en el congelador para que tome cuerpo y endurezca un poco. " +
                "Mezclamos la cuajada en polvo con el azúcar glas y le añadimos 80 g de leche. Removemos hasta disolver. Calentamos los 20 g de leche restantes junto con el queso crema y cuando comience a hervir, incorporamos la mezcla anterior. Removemos al tiempo que toma temperatura y retiramos del fuego cuando alcance de nuevo el hervor. " +
                "Rellenamos el molde con la mezcla y dejamos atemperar antes de introducir en la nevera donde esperaremos a que solidifique durante, al menos, un par de horas antes de desmoldar y decorar con fruta, mermelada o lo que más nos guste o tengamos a mano. Servimos fría de la nevera.",
                15),

            Receta(4,
                "Arroz tres delicias",
                "Arroz de grano largo tipo basmati, jazmín, thai, etc 400 g, Zanahoria 1, Gambas 150 g, Guisantes 75 g, Jamón de York en taquitos 75 g, Huevos 2, Salsa de soja 20 ml, Azúcar 10 g, Aceite de oliva virgen extra 20 ml",
                "Cortamos la zanahoria en dados pequeños y la ponemos a cocer en una cacerola con agua y un poco de sal. Abrimos la lata de guisantes. Batimos los huevos con la sal y una cucharadita de azúcar y preparamos una tortilla francesa en dos tandas, usando una sartén bien caliente con media cucharada de aceite de oliva. La tortilla debe quedarnos bastante fina, tipo crêpe. " +
                "Mientras tanto, ponemos en otro cazo con agua de sal el arroz largo tipo basmati o thai a cocer. En unos diez minutos estará listo, dependiendo de la variedad, momento en el que lo escurrimos y reservamos. Mientras cuece, cortamos el jamón de York en taquitos. " +
                "Salteamos las gambas ligeramente en una sartén amplia con el resto del aceite de oliva, y como ya tenemos todos los ingredientes listos, procedemos a preparar el plato de arroz tres delicias. Para ello, añadimos el arroz bien escurrido a la sartén, y sazonamos con las cucharadas de salsa de soja. " +
                "Una vez bien salteado, agregamos los demás ingredientes, salteando para que todos se mezclen en la sartén y una vez listos lo pasamos a una fuente y lo servimos inmediatamente, muy caliente con un poco de salsa de soja aparte para que quien quiera pueda añadirla a su gusto.",
            20),

            Receta(5,
                "Crema de champiñones", "Cebolla dulce, morada o cebolleta grande, Dientes de ajo, Champiñones, Vino blanco, Caldo de verduras o pollo, Tomillo seco, Romero seco, Pimienta negra molida, Sal, Aceite de oliva virgen extra o mantequilla, Cebollino",
                "Lavar bien los champiñones y secar con suavidad. Para una crema yo prefiero usar ejemplares grandes y enteros, salen más baratos que las típicas bandejas en las que ya vienen laminados. Trocear y reservar. " +
                "Picar la cebolla y el diente de ajo. Calentar un poco de aceite o de mantequilla en una olla o cazuela y pochar la cebolla con una pizca de sal. Cuando empiece a estar blanda, añadir el ajo y cocinar un par de minutos. " +
                "Incorporar los champiñones, salpimentar y remover. Regar con el vino y dejar que evapore el alcohol. Añadir el tomillo y el romero y dejar que se doren. Cubrir con el caldo -podemos reservar un poco y ajustar la cantidad al final-, llevar a ebullición, tapar y reducir la temperatura. Cocer unos 10 minutos. " +
                "Si estuviera demasiado líquido, cocer un poco más sin la tapa para que reduzca. Separar del fuego y triturar, ajustando el nivel de espesor al gusto. Corregir de sal y servir con cebollino picado y un golpe de pimienta.",
                25),

            Receta(6,
                "Serranito, el clásico bocadillo del sur",
                "Lomo de cerdo sin adobar 2 rodajas, Pimiento verde italiano 1, Jamón serrano (lonchas) 2, Pan de bocadillo (Viena) 1, Patata para freír 1, Tomate 0.5",
                "Este bocadillo de lomo, pimientos y jamón se suele servir en pan blanco y tierno como la viena andaluza. Comenzamos friendo las patatas, que actuarán como guarnición de nuestro bocadillo, como manda la tradición." +
                "Después freímos los pimientos que también tardan un rato en estar listos. Los ponemos en una sartén enteros con abundante aceite teniendo cuidado para no quemarnos si salpican. Los hacemos hasta que su piel esté quemadita y se pueda retirar si se desea. " +
                "Recordad que un buen truco para que queden bien tiernos los pimientos es freírlos con agua como os contamos aquí. Una vez fritos los pimientos, les quitamos la cabeza, los abrimos y retiramos las semillas y los reservamos. Ponemos las lonchas de lomo de cerdo a la plancha y las hacemos hasta que se doren. Entre tanto vamos pelando el tomate y cortamos un par de rodajas. " +
                "Colocamos el tomate en la base del pan, cubrimos con las lonchas de lomo de cerdo, el pimiento verde abierto y terminamos con el jamón serrano, de donde toma el nombre este bocadillo. Como guarnición servimos las patatas fritas y llevamos a la mesa.",
                20),

            Receta(7,
                "Atún con berenjena y tomatitos",
                "Cebolleta 0.5, Berenjena 1, Tomate cherry 200 g, Atún fresco o descongelado, limpio 300 g, Vino blanco 50 ml, Pasta o concentrado de guindilla roja 2.5 ml, Caldo de pescado o fumet o verduras o agua 200 ml, Pimienta negra molida, Sal, Aceite de oliva virgen extra, Albahaca",
                "Picar la cebolleta y cortar la berenjena en cubos pequeños. Calentar un par de cucharadas de aceite de oliva en una sartén y pochar la cebolleta unos minutos. Incorporar la berenjena, salpimentar y saltear unos 10 minutos a fuego medio. " +
                "Incorporar los tomatitos, partidos por la mitad si son algo grandes, y regar con el vino blanco. Agregar la pasta de guindilla, remover bien y cubrir con el caldo o agua. Llevar a ebullición, tapar y dejar cocer a fuego medio-bajo unos 10-15 minutos. " +
                "Destapar y remover. Continuar la cocción unos minutos más hasta que las verduras estén bien cocinadas. Añadir el atún troceado, tapar y cocinar unos pocos minutos más, hasta que el pescado esté en su punto. Salpimentar y agregar unas hojas de albahaca picada.",
                40),

            Receta(8,
                "Solomillo de pavo en salsa de mostaza y romero",
                "Solomillo de pavo, Mostaza de Dijon, Crema de leche o nata líquida, Romero fresco, Ajo, Aceite de oliva virgen extra, Sal, Pimienta negra molida",
                "Para hacer el solomillo de pavo, cortamos el solomillo en medallones de tamaño uniforme. En una sartén grande, calentamos un poco de aceite de oliva y doramos los medallones de pavo por ambos lados. " +
                "Cuando estén dorados, retiramos el pavo de la sartén y reservamos. En la misma sartén, añadimos un poco más de aceite de oliva y sofreímos el ajo picado. Cuando el ajo esté dorado, incorporamos la mostaza de Dijon y la nata líquida. " +
                "Cocinamos a fuego medio hasta que la salsa espese ligeramente. Agregamos el romero fresco y sazonamos con sal y pimienta al gusto. Vuelvemos a incorporar los medallones de pavo a la sartén y cocinamos a fuego bajo durante unos minutos para que se impregnen bien con la salsa. " +
                "Servir el solomillo de pavo con la salsa por encima y acompañar con un acompañante al gusto, como arroz o verduras al vapor.",
                25),

            Receta(9,
                "Salmón al horno con patatas",
                "Lomos de salmón fresco, Patatas, Aceite de oliva virgen extra, Ajo, Limón, Pimentón, Sal, Pimienta negra molida",
                "Precalentar el horno a 180ºC. Pelar las patatas y cortarlas en rodajas finas. Colocar las rodajas de patata en una bandeja de horno, rociarlas con aceite de oliva y sazonarlas con sal y pimienta. " +
                "Hornear las patatas durante unos 20 minutos o hasta que estén tiernas. Mientras tanto, preparar el salmón. Colocar los lomos de salmón en una fuente de horno y rociar con un poco de aceite de oliva. " +
                "Exprimir el jugo de un limón sobre el salmón, agregar el ajo picado, espolvorear con pimentón, y sazonar con sal y pimienta al gusto. " +
                "Colocar el salmón en el horno durante unos 15 minutos o hasta que se cocine al gusto. Servir el salmón con las patatas asadas. Si se desea, decorar con rodajas de limón y hierbas frescas.",
                30),

            Receta(10,
                "Espárragos al horno gratinados con mozzarella",
                "Espárragos trigueros, Queso Mozzarella, Aceite de oliva virgen extra, Pan rallado, Sal, Pimienta negra molida",
                "Limpiar los espárragos y cortar la parte inferior del tallo. Esparcir aceite de oliva sobre una fuente apta para horno y colocar los espárragos. Salpimentar. Picar el queso mozzarella lo más finamente posible y esparcirlo sobre los espárragos. Espolvorear el pan molido. Ajustar la sazón con más sal de ser necesario y un poco de aceite de oliva. " +
                "Colocar en horno caliente a 200ºC por unos 20 minutos aproximadamente o hasta que el queso está derretido y doradito.",
                25)
        )

        for (receta in recetas) {
            val sql = "INSERT INTO $TABLE_NAME ($COLUMN_NAME, $COLUMN_INGREDIENTS, $COLUMN_STEPS, $COLUMN_TIME) VALUES (?, ?, ?, ?)"
            db?.execSQL(sql, arrayOf(receta.nombre, receta.ingredientes, receta.modo_de_preparacion, receta.tiempo_total))

        }


    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

}