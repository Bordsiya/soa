package com.example.thirdservice;

class JerseyHttpClientFactory {
    /*

    static Client getJerseyHTTPSClient() {
        SSLContext sslContext = null;
        try {
            sslContext = getSslContext();
        } catch (NoSuchAlgorithmException | KeyManagementException | IOException | KeyStoreException |
                 CertificateException e) {
            throw new RuntimeException(e);
        }
        HostnameVerifier allHostsValid = new LocalHostnameVerifier();

        return ClientBuilder.newBuilder()
                .sslContext(sslContext)
                .hostnameVerifier(allHostsValid)
                .build();
    }

    private static SSLContext getSslContext() throws NoSuchAlgorithmException,
            KeyManagementException, IOException, KeyStoreException, CertificateException {

        FileInputStream myKeys = new FileInputStream("C:/Users/Nastya/IdeaProjects/soa/third-service/WebContent/keystore/orgdirectory.jks");
        KeyStore myTrustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        myTrustStore.load(myKeys, "orgdirectory".toCharArray());
        myKeys.close();

        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(myTrustStore);

        X509TrustManager myTm = null;
        for (TrustManager tm : tmf.getTrustManagers()) {
            if (tm instanceof X509TrustManager) {
                myTm = (X509TrustManager) tm;
                break;
            }
        }

        SSLContext sslContext = SSLContext.getInstance("TLSv1");
        sslContext.init(null, new TrustManager[] { myTm }, null);

        return sslContext;
    }

    private static class LocalHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return "localhost".equalsIgnoreCase(hostname) || "127.0.0.1".equals(hostname);
        }
    }

     */
}
