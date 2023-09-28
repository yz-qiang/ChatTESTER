/*
   Copyright 2022 Carlos Macasaet

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       https://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
import java.util.Arrays;
import java.util.function.Function;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.macasaet.fernet.Key;
import com.macasaet.fernet.Token;
import com.macasaet.fernet.Validator;

/**
 * This fuzzer simulates an attacker who has access to the system and is attempting to exploit the token mechanism.
 */
public class TokenEncryptDecryptFuzzer {

    /*
     * Run each fuzz input against the same key. Note that in practice, the key is likely rotated on a regular basis.
     */
    final static Key key = new Key("UrNImCIJQuYODgrBU5NgH5rpTc7l52IS5ELuhwF4RHU=");
    final static Validator<byte[]> validator = () -> Function.identity();

    public static void fuzzerTestOneInput(final FuzzedDataProvider data) {
        final var payload = data.consumeBytes(4096);
        final var token = Token.generate(key, payload);
        final var serialised = token.serialise();
        final var deserialised = Token.fromString(serialised);
        final var decrypted = deserialised.validateAndDecrypt(key, validator);
        if (!Arrays.equals(payload, decrypted)) {
            throw new IllegalStateException("Encryption/decryption fault");
        }
    }
}
