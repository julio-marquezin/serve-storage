package com.crea.storage.service;

import com.crea.storage.exception.FTPConnectionException;
import com.crea.storage.exception.FTPDisconnectException;
import com.crea.storage.exception.FTPOperationException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Service
public class FTPService {

    private final FTPClient ftpClient;


    public FTPService() {
        this.ftpClient = new FTPClient();
    }

    public void connect(String host, String username, String password) {
        try {
            ftpClient.connect(host);
            ftpClient.login(username, password);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            throw new FTPConnectionException(e, "FTP connection failed", host, username);
        }
    }

    public void disconnect() {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new FTPDisconnectException(e, "Couldn't disconnect'", ftpClient.getRemoteAddress().getHostName());
            }
        }
    }

    public boolean storeFile(String file, InputStream inputStream) {
        try {
            return ftpClient.storeFile(file, inputStream);
        } catch (IOException e) {
            throw new FTPOperationException("Failed to store file.", e);
        }
    }

    public boolean storeDirectory(String directory, Map<String, InputStream> fileStreams) {
        boolean allStored = true;

        for (Map.Entry<String, InputStream> fileStream : fileStreams.entrySet()) {
            try {
                String newFile = directory + FilenameUtils.getBaseName(fileStream.getKey());
                allStored &= ftpClient.storeFile(newFile, fileStream.getValue());
            } catch (IOException e) {
                throw new FTPOperationException("Failed to store files.", e);
            }
        }

        return allStored;
    }

    public boolean retrieveFile(String file, OutputStream outputStream) {
        try {
            return ftpClient.retrieveFile(file, outputStream);
        } catch (IOException e) {
            throw new FTPOperationException("Failed to retrieve file.", e);
        }
    }

    public List<FTPFile> retrieveDirectory(String directoryPath) {
        try {
            return List.of(ftpClient.mlistDir(directoryPath));
        } catch (IOException e) {
            throw new FTPOperationException("Failed to download directory.", e);
        }
    }

    public List<FTPFile> listFiles(String folder) {
        try {
            return List.of(ftpClient.listFiles(folder));
        } catch (IOException e) {
            throw new FTPOperationException("Couldn't list files", e);
        }
    }

    public List<FTPFile> listDirectories(String directoryPath) {
        try {
            return List.of(ftpClient.listDirectories(directoryPath));
        } catch (IOException e) {
            throw new FTPOperationException("Couldn't list directories", e);
        }
    }

    public List<String> listNames(String folder) {
        try {
            return List.of(ftpClient.listNames(folder));
        } catch (IOException e) {
            throw new FTPOperationException("Couldn't list file names", e);
        }
    }

    public boolean rename(String oldPath, String newPath) {
        try {
            return ftpClient.rename(oldPath, newPath);
        } catch (IOException e) {
            throw new FTPOperationException("Failed to rename directory.", e);
        }    }

    public boolean deleteFile(String file) {
        try {
            return ftpClient.deleteFile(file);
        } catch (IOException e) {
            throw new FTPOperationException("Error deleting file.", e);
        }
    }

    public boolean deleteDirectory(String directoryPath) {
        try {
            return ftpClient.removeDirectory(directoryPath);
        } catch (IOException e) {
            throw new FTPOperationException("Error deleting directory.", e);
        }
    }

}
