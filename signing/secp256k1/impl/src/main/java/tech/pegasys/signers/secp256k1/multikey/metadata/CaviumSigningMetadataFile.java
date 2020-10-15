/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.signers.secp256k1.multikey.metadata;

import tech.pegasys.signers.secp256k1.api.Signer;
import tech.pegasys.signers.secp256k1.cavium.CaviumConfig;
import tech.pegasys.signers.secp256k1.multikey.MultiSignerFactory;

public class CaviumSigningMetadataFile extends SigningMetadataFile {

  private final CaviumConfig config;

  public CaviumSigningMetadataFile(final String filename, final CaviumConfig config) {
    super(filename);
    this.config = config;
  }

  public CaviumConfig getConfig() {
    return config;
  }

  @Override
  public Signer createSigner(final MultiSignerFactory factory) {
    return factory.createSigner(this);
  }
}
