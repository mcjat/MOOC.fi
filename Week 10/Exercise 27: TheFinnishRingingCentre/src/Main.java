public class Main {
    /**
     * @param args the command line arguments
     */     
    public static void main(String[] args) {
        // TODO code application logic here
        RingingCentre kumpulaCentre = new RingingCentre();

        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia" );
        kumpulaCentre.observe( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila" );
        kumpulaCentre.observe( new Bird("European Herring Gull", "Larus argentatus", 2008), "Kumpulanmäki" );
        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2008), "Mannerheimintie" );

        kumpulaCentre.observations( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012 ) );
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 2008 ) );
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 1980 ) );
    }
}
