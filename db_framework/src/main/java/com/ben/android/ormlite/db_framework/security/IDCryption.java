package com.ben.android.ormlite.db_framework.security;

import com.ben.android.ormlite.db_framework.ORMLiteConfiguration;

interface IDCryption {
    SecurityResponse _decryption(ORMLiteConfiguration configuration, String source);
}
