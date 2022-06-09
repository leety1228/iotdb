/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.iotdb.rpc;

import java.util.HashMap;
import java.util.Map;

public enum TSStatusCode {
  SUCCESS_STATUS(200),
  STILL_EXECUTING_STATUS(201),
  INVALID_HANDLE_STATUS(202),
  INCOMPATIBLE_VERSION(203),

  NODE_DELETE_FAILED_ERROR(298),
  ALIAS_ALREADY_EXIST_ERROR(299),
  PATH_ALREADY_EXIST_ERROR(300),
  PATH_NOT_EXIST_ERROR(301),
  UNSUPPORTED_FETCH_METADATA_OPERATION_ERROR(302),
  METADATA_ERROR(303),
  TIMESERIES_NOT_EXIST(304),
  OUT_OF_TTL_ERROR(305),
  CONFIG_ADJUSTER(306),
  MERGE_ERROR(307),
  SYSTEM_CHECK_ERROR(308),
  SYNC_CONNECTION_EXCEPTION(310),
  DATA_REGION_ERROR(311),
  STORAGE_GROUP_ERROR(312),
  STORAGE_ENGINE_ERROR(313),
  TSFILE_PROCESSOR_ERROR(314),
  PATH_ILLEGAL(315),
  LOAD_FILE_ERROR(316),
  STORAGE_GROUP_NOT_READY(317),
  ILLEGAL_PARAMETER(318),
  ALIGNED_TIMESERIES_ERROR(319),
  DUPLICATED_TEMPLATE(320),
  UNDEFINED_TEMPLATE(321),
  STORAGE_GROUP_NOT_EXIST(322),
  CONTINUOUS_QUERY_ERROR(323),
  NO_TEMPLATE_ON_MNODE(324),
  DIFFERENT_TEMPLATE(325),
  TEMPLATE_IS_IN_USE(326),
  TEMPLATE_IMCOMPATIBLE(327),
  SEGMENT_NOT_FOUND(328),
  PAGE_OUT_OF_SPACE(329),
  RECORD_DUPLICATED(330),
  SEGMENT_OUT_OF_SPACE(331),
  SCHEMA_FILE_NOT_EXISTS(332),
  WRITE_AHEAD_LOG_ERROR(333),
  PIPESINK_ERROR(334),
  PIPE_ERROR(335),
  PIPESERVER_ERROR(336),
  SERIES_OVERFLOW(337),

  EXECUTE_STATEMENT_ERROR(400),
  SQL_PARSE_ERROR(401),
  GENERATE_TIME_ZONE_ERROR(402),
  SET_TIME_ZONE_ERROR(403),
  NOT_STORAGE_GROUP_ERROR(404),
  QUERY_NOT_ALLOWED(405),
  AST_FORMAT_ERROR(406),
  LOGICAL_OPERATOR_ERROR(407),
  LOGICAL_OPTIMIZE_ERROR(408),
  UNSUPPORTED_FILL_TYPE_ERROR(409),
  PATH_ERROR(410),
  QUERY_PROCESS_ERROR(411),
  WRITE_PROCESS_ERROR(412),
  WRITE_PROCESS_REJECT(413),
  QUERY_ID_NOT_EXIST(414),
  SNAPSHOT_DIR_NOT_LEGAL(415),
  SEMANTIC_ERROR(416),

  UNSUPPORTED_INDEX_FUNC_ERROR(421),
  UNSUPPORTED_INDEX_TYPE_ERROR(422),

  INTERNAL_SERVER_ERROR(500),
  CLOSE_OPERATION_ERROR(501),
  READ_ONLY_SYSTEM_ERROR(502),
  DISK_SPACE_INSUFFICIENT_ERROR(503),
  START_UP_ERROR(504),
  SHUT_DOWN_ERROR(505),
  MULTIPLE_ERROR(506),

  WRONG_LOGIN_PASSWORD_ERROR(600),
  NOT_LOGIN_ERROR(601),
  NO_PERMISSION_ERROR(602),
  UNINITIALIZED_AUTH_ERROR(603),
  EXECUTE_PERMISSION_EXCEPTION_ERROR(604),
  USER_NOT_EXIST_ERROR(605),
  ROLE_NOT_EXIST_ERROR(606),
  AUTHENTICATION_ERROR(607),
  INVALIDATE_PERMISSION_CACHE_ERROR(608),

  // cluster-related errors
  PARTITION_NOT_READY(700),
  TIME_OUT(701),
  NO_LEADER(702),
  UNSUPPORTED_OPERATION(703),
  NODE_READ_ONLY(704),
  CONSISTENCY_FAILURE(705),
  NO_CONNECTION(706),
  NEED_REDIRECTION(707),
  PARSE_LOG_ERROR(708),
  ALL_RETRY_FAILED(709),

  // configuration
  CONFIG_ERROR(800),

  // ConfigNode response
  DATANODE_ALREADY_REGISTERED(901),
  STORAGE_GROUP_ALREADY_EXISTS(902),
  NOT_ENOUGH_DATA_NODE(903),
  ERROR_GLOBAL_CONFIG(904),
  APPLY_CONFIGNODE_FAILED(905),
  PERSISTENCE_FAILURE(906);

  private int statusCode;

  private static final Map<Integer, TSStatusCode> CODE_MAP = new HashMap<>();

  static {
    for (TSStatusCode value : TSStatusCode.values()) {
      CODE_MAP.put(value.getStatusCode(), value);
    }
  }

  TSStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public static TSStatusCode representOf(int statusCode) {
    return CODE_MAP.get(statusCode);
  }

  @Override
  public String toString() {
    return String.format("%s(%d)", name(), getStatusCode());
  }
}
