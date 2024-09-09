package com.aop.carfactsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {


    public static ModelDatabase database;

    @Override protected void onCreate(Bundle savedInstanceState) {
        database= Room.databaseBuilder(getApplicationContext(),ModelDatabase.class,"database-cars")
                .allowMainThreadQueries().build();

        ModelDao ModelDao = database.modelDao();

        Model[] allModels = ModelDao.getAllModels();

        if(allModels.length==0){
            loadModels(ModelDao);
        }

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void loadModels(ModelDao d){ //This should really be automated, but I get no points for that

        Model bmw = new Model();
        Model mini = new Model();
        Model ford = new Model();
        Model nissan = new Model();
        Model porsche = new Model();
        Model renault = new Model();
        Model plymouth2 = new Model();
        Model volvo = new Model();


        bmw.name="BMW 2002 Turbo";
        bmw.specSheet ="Engine:\n" +
                "\n" +
                "Type: Inline-four, turbocharged\n" +
                "Displacement: 2.0 liters\n" +
                "Power: 170 hp\n" +
                "Torque: 240 Nm\n" +
                "Compression Ratio: 6.9:1\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual\n" +
                "Drivetrain: Rear-wheel drive";
        bmw.story = "The BMW 2002 Turbo is regarded as one of the first production cars to feature turbocharging technology.\n" +
                "It was initially released in limited numbers due to the oil crisis of the early 1970s, which affected demand for high-performance vehicles.\n" +
                "The 2002 Turbo has since become a sought-after classic among enthusiasts, known for its driving dynamics and iconic design.";
        bmw.imageId ="bmw2002t.jpeg";

        mini.name="Mini Clubman";
        mini.specSheet = "Engine:\n" +
                "\n" +
                "Type: Inline-four\n" +
                "Displacement: 1.0 to 1.3 liters (various engine options)\n" +
                "Power: Ranges from approximately 34 hp to 75 hp (depending on engine variant)\n" +
                "Torque: Varies depending on engine variant\n" +
                "Compression Ratio: Varies depending on engine variant\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual (5-speed manual available on later models)\n" +
                "Drivetrain: Front-wheel drive";

        mini.story="The Mini Clubman was introduced in 1969 as a larger and more refined version of the classic Mini.\n" +
                "Engine options varied across different markets and model years, ranging from 1.0 to 1.3 liters in displacement.\n" +
                "Power and torque figures varied depending on the specific engine variant.\n" +
                "The Clubman featured a longer front end and squared-off styling compared to the classic Mini.\n" +
                "It was available in various body styles, including saloon, estate, and van configurations.\n" +
                "Production of the Mini Clubman continued until the early 1980s when it was replaced by the Austin Metro.";

        ford.name="Ford Mustang Boss 302";
        ford.specSheet="Engine:\n" +
                "\n" +
                "Type: V8\n" +
                "Displacement: 5.0 liters (302 cubic inches)\n" +
                "Power: 290 hp @ 5800 rpm\n" +
                "Torque: 290 lb-ft @ 4300 rpm\n" +
                "Compression Ratio: 10.5:1\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual (optional 3-speed automatic)\n" +
                "Drivetrain: Rear-wheel drive";
        ford.story="The Ford Mustang Boss 302 was introduced as a high-performance variant of the Mustang for Trans-Am racing homologation purposes.\n" +
                "It featured a specially tuned version of Ford's 302 cubic inch V8 engine.\n" +
                "The Boss 302 was known for its track-oriented performance and aggressive styling cues.\n" +
                "It remains a highly sought-after classic among Mustang enthusiasts.";

        nissan.name="Nissan 240Z";
        nissan.specSheet="Engine:\n" +
                "\n" +
                "Type: Inline-six\n" +
                "Displacement: 2.4 liters\n" +
                "Power: Approximately 151 hp @ 5600 rpm\n" +
                "Torque: Approximately 146 lb-ft @ 4400 rpm\n" +
                "Compression Ratio: 9.0:1\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual (5-speed manual available on later models)\n" +
                "Drivetrain: Rear-wheel drive";
        nissan.story="The Nissan 240Z, also known as the Fairlady Z in Japan, was introduced as a sports car to compete with European counterparts.\n" +
                "It was praised for its sleek design, powerful engine, and excellent handling characteristics.\n" +
                "The 240Z became an iconic car of the 1970s and played a significant role in establishing Nissan's reputation for producing high-performance sports cars.";


        porsche.name="Porsche 911 Turbo";
        porsche.specSheet="Engine:\n" +
                "\n" +
                "Type: Flat-six, turbocharged\n" +
                "Displacement: 3.3 liters\n" +
                "Power: Approximately 300 hp @ 5500 rpm\n" +
                "Torque: Approximately 330 lb-ft @ 4000 rpm\n" +
                "Compression Ratio: 7.0:1\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual\n" +
                "Drivetrain: Rear-engine, rear-wheel drive";
        porsche.story="The Porsche 911 Turbo, also known as the Porsche 930, was the flagship model of the 911 range in the late 1970s.\n" +
                "It was one of the fastest production cars of its time, known for its exhilarating performance and iconic design.\n" +
                "The 911 Turbo helped establish Porsche as a leader in the high-performance sports car market and has since become a highly sought-after classic among collectors and enthusiasts.";

        renault.name="Renault 5 Turbo";
        renault.specSheet="Engine:\n" +
                "\n" +
                "Type: Inline-four, turbocharged\n" +
                "Displacement: 1.4 to 1.5 liters (various engine options)\n" +
                "Power: Ranges from approximately 160 hp to 185 hp (depending on engine variant)\n" +
                "Torque: Varies depending on engine variant\n" +
                "Compression Ratio: Varies depending on engine variant\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 5-speed manual\n" +
                "Drivetrain: Mid-engine, rear-wheel drive";
        renault.story="The Renault 5 Turbo was developed as a rally car homologation special, based on the Renault 5 hatchback.\n" +
                "It featured a mid-engine layout for improved handling and was designed to compete in Group 4 and Group B rallying.\n" +
                "The Renault 5 Turbo achieved considerable success in rallying, including several victories in the World Rally Championship.\n" +
                "It is highly regarded among automotive enthusiasts for its unique design and impressive performance capabilities.";

        plymouth2.name="Plymouth Superbird";
        plymouth2.specSheet="Engine:\n" +
                "\n" +
                "Type: V8\n" +
                "Displacement: 7.0 liters (426 cubic inches)\n" +
                "Power: Approximately 425 hp @ 5000 rpm\n" +
                "Torque: Approximately 490 lb-ft @ 4000 rpm\n" +
                "Compression Ratio: 10.25:1\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual (optional 3-speed automatic)\n" +
                "Drivetrain: Rear-wheel drive";

        plymouth2.story="The Plymouth Superbird was developed for NASCAR racing homologation purposes, specifically to compete in the high-speed oval tracks of NASCAR.\n" +
                "It featured a unique aerodynamic design with a high-mounted rear wing and elongated nose cone to improve aerodynamic efficiency and stability at high speeds.\n" +
                "The Superbird was highly successful in NASCAR racing, winning multiple races and championships.\n" +
                "It has since become an iconic and highly collectible muscle car, prized for its rarity, performance, and distinctive appearance.";

        volvo.name="Volvo 240";
        volvo.specSheet="Engine:\n" +
                "\n" +
                "Type: Inline-four or Inline-six\n" +
                "Displacement: Ranges from 2.0 to 2.3 liters for inline-four engines, and 2.3 liters for inline-six engines\n" +
                "Power: Ranges from approximately 82 hp to 155 hp (depending on engine variant)\n" +
                "Torque: Varies depending on engine variant\n" +
                "Compression Ratio: Varies depending on engine variant\n" +
                "Transmission:\n" +
                "\n" +
                "Type: 4-speed manual or 3-speed automatic (5-speed manual available on later models)\n" +
                "Drivetrain: Rear-wheel drive";
        volvo.story="The Volvo 240 was renowned for its reliability, safety, and longevity, becoming an iconic symbol of Volvo's reputation for building durable and practical cars.\n" +
                "It was widely used as a family car, taxi, and even as a rally car, showcasing its versatility and ruggedness.\n" +
                "The Volvo 240 has a dedicated fanbase and continues to be cherished by enthusiasts worldwide for its simplicity, durability, and understated charm.";



        d.insertAll(bmw,mini,ford,nissan,porsche,renault,plymouth2,volvo);
    }

}