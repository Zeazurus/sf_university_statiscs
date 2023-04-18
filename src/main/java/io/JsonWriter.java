package io;

import model.FullInfo;
import util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJsonReq(FullInfo fullInfo) {

        logger.log(Level.INFO, "JSON запись...");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Директория создана.");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Директория уже существует!", ioEx);
        }

        writeStudents(fullInfo);
        writeUniversities(fullInfo);
        writeStatisticsList(fullInfo);

        logger.log(Level.INFO, "JSON запись завершена.");
    }

    private static void writeStudents(FullInfo fullInfo) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStudentList());
        try (FileOutputStream outputStream =
                     new FileOutputStream("jsonReqs/students" + fullInfo.getProcessDate().getTime() + ".json")) {
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "JSON запись студентов провалена.", e);
        }
    }

    private static void writeUniversities(FullInfo fullInfo) {
        String universitiesJson = JsonUtil.writeListToJson(fullInfo.getUniversityList());
        try (FileOutputStream outputStream =
                     new FileOutputStream("jsonReqs/universities" + fullInfo.getProcessDate().getTime() + ".json")) {
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "JSON запись университетов провалена.", e);
        }
    }

    private static void writeStatisticsList(FullInfo fullInfo) {
        String studentsJson = JsonUtil.writeListToJson(fullInfo.getStatisticsList());
        try (FileOutputStream outputStream =
                     new FileOutputStream("jsonReqs/statistics" + fullInfo.getProcessDate().getTime() + ".json")){
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "JSON запись статистики провалена.", e);
        }
    }
}