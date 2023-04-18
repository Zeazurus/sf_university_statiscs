package io;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import model.FullInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    private static final Logger logger = Logger.getLogger(XmlWriter.class.getName());

    private XmlWriter() {
    }

    public static void generateXmlReq(FullInfo fullInfo) {

        try {
            logger.log(Level.INFO, "XML маршаллинг...");

            JAXBContext jaxbContext = JAXBContext.newInstance(FullInfo.class);

            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            try {
                Files.createDirectory(Paths.get("xmlReqs"));
                logger.log(Level.INFO, "Директория создана.");
            } catch (IOException ioEx) {
                logger.log(Level.FINE, "Директория уже есть!", ioEx);
            }
            File requestFile = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

            marshaller.marshal(fullInfo, requestFile);
        } catch (JAXBException jaxbEx) {
            logger.log(Level.SEVERE, "XML маршаллинг провален.", jaxbEx);
            return;
        }

        logger.log(Level.INFO, "XML маршаллинг завершен.");
    }
}