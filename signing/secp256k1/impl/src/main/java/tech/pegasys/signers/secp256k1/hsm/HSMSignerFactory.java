/*
 * Copyright 2019 ConsenSys AG.
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
package tech.pegasys.signers.secp256k1.hsm;

import tech.pegasys.signers.hsm.HSMWalletProvider;
import tech.pegasys.signers.secp256k1.api.Signer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HSMSignerFactory {

  protected static final Logger LOG = LogManager.getLogger();
  private final HSMWalletProvider provider;

  public HSMSignerFactory(final HSMWalletProvider provider) {
    this.provider = provider;
  }

  public String getSlotLabel() {
    return provider.getWallet().getLabel();
  }

  public void shutdown() {
    provider.shutdown();
  }

  public Signer createSigner(String address) {
    return new HSMSigner(provider, address);
  }
}