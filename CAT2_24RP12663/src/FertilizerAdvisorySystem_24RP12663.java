// File: FertilizerAdvisorySystem_24RP12663.java

class SoilAnalysis {
    // --- Fields ---
    private String farmerId;
    private String districtName;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String cropType;

    // --- Constructor ---
    public SoilAnalysis(String farmerId, String districtName, double nitrogenLevel,
                        double phosphorusLevel, double potassiumLevel, String cropType) {
        this.farmerId = farmerId;
        this.districtName = districtName;
        this.nitrogenLevel = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel = potassiumLevel;
        this.cropType = cropType;
    }

    // --- Check if nutrients are balanced ---
    public boolean isBalanced() {
        return (nitrogenLevel >= 20 && nitrogenLevel <= 100) &&
                (phosphorusLevel >= 20 && phosphorusLevel <= 100) &&
                (potassiumLevel >= 20 && potassiumLevel <= 100);
    }

    // --- Calculate fertilizer recommendation ---
    public String calculateFertilizerNeeded() {
        // Check for invalid nutrient readings
        if (nitrogenLevel <= 0 || phosphorusLevel <= 0 || potassiumLevel <= 0) {
            throw new IllegalArgumentException("Invalid nutrient reading for farmer ID: " + farmerId);
        }

        // Balanced
        if (isBalanced()) {
            return "Optimal – maintenance fertilizer only.";
        }

        // Check for deficiencies or excesses
        StringBuilder message = new StringBuilder();

        boolean deficient = false;
        boolean excess = false;
        StringBuilder deficientNutrients = new StringBuilder();
        StringBuilder excessNutrients = new StringBuilder();

        // Check deficient nutrients (<20 ppm)
        if (nitrogenLevel < 20) {
            deficient = true;
            deficientNutrients.append("Nitrogen ");
        }
        if (phosphorusLevel < 20) {
            deficient = true;
            deficientNutrients.append("Phosphorus ");
        }
        if (potassiumLevel < 20) {
            deficient = true;
            deficientNutrients.append("Potassium ");
        }

        // Check excess nutrients (>100 ppm)
        if (nitrogenLevel > 100) {
            excess = true;
            excessNutrients.append("Nitrogen ");
        }
        if (phosphorusLevel > 100) {
            excess = true;
            excessNutrients.append("Phosphorus ");
        }
        if (potassiumLevel > 100) {
            excess = true;
            excessNutrients.append("Potassium ");
        }

        if (deficient) {
            message.append("Deficient – high application needed for [")
                    .append(deficientNutrients.toString().trim())
                    .append("].");
        }
        if (excess) {
            if (message.length() > 0) message.append(" ");
            message.append("Excess – reduce [")
                    .append(excessNutrients.toString().trim())
                    .append("] application.");
        }

        return message.toString().trim();
    }

    // --- Display analysis summary ---
    public String displayAnalysis() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farmer ID: ").append(farmerId).append("\n");
        sb.append("District: ").append(districtName).append("\n");
        sb.append("Crop Type: ").append(cropType).append("\n");
        sb.append("N: ").append(nitrogenLevel).append(" ppm,  ");
        sb.append("P: ").append(phosphorusLevel).append(" ppm,  ");
        sb.append("K: ").append(potassiumLevel).append(" ppm\n");

        try {
            sb.append("Fertilizer Recommendation: ").append(calculateFertilizerNeeded()).append("\n");
        } catch (IllegalArgumentException ex) {
            sb.append("Error: ").append(ex.getMessage()).append("\n");
        }

        sb.append("-----------------------------------------------\n");
        return sb.toString();
    }
}

// ---------------------------------------------------------
// Fertilizer Advisory System main class
// ---------------------------------------------------------
public class FertilizerAdvisorySystem_24RP12663 {
    public static void main(String[] args) {
        System.out.println("SMART AGRICULTURE – IHINDUKA CONNECT (Fertilizer Advisory System)\n");

        // Create sample SoilAnalysis objects
        SoilAnalysis[] samples = new SoilAnalysis[5];
        samples[0] = new SoilAnalysis("F001", "Kigali", 45, 60, 80, "Maize");  // Balanced
        samples[1] = new SoilAnalysis("F002", "Rwamagana", 15, 70, 50, "Beans"); // Deficient
        samples[2] = new SoilAnalysis("F003", "Musanze", 0, 55, 60, "Potatoes"); // Invalid
        samples[3] = new SoilAnalysis("F004", "Gisagara", 110, 90, 105, "Rice"); // Excess
        samples[4] = new SoilAnalysis("F005", "Nyagatare", 25, 18, 120, "Wheat"); // Mixed (Deficient + Excess)

        // Display all results
        for (SoilAnalysis s : samples) {
            System.out.println(s.displayAnalysis());
        }
    }
}
